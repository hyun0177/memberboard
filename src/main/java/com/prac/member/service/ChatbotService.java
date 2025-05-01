package com.prac.member.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatbotService {

    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final String EAPI_URL = "https://api.openai.com/v1/embeddings";

    private static final String API_KEY = System.getenv("OPENAI_API_KEY");
    // 대화 히스토리 저장
    private List<Map<String, String>> conversationHistory = new ArrayList<>();

    public ChatbotService() {
        resetConversationHistory();
    }

    public void resetConversationHistory() {
        conversationHistory.clear(); // 히스토리 초기화
        Map<String, String> systemMessage = new HashMap<>();
        systemMessage.put("role", "system");
        systemMessage.put("content", "너는 이제부터 나의 상황을 듣고 감정을 예측해줄 심리 상담가야. 너랑 내가 대화를 하는 동안 너는 내 감정을 분석하고, 그에 맞는 반응을 보여줘. 답변은 1~2문장으로 짧게 해줬으면 좋겠고, 너로 인해 대화가 끊기지 않게 끊임 없이 물어봐줘");
        conversationHistory.add(systemMessage); // 시스템 메시지 추가
    }

    // 감정 분석 요청을 GPT에 전달
    public String getEmotionAnalysis() throws JsonProcessingException {
        String conversationText = buildConversationText();  // 대화 내용 텍스트 생성

        // ObjectMapper를 사용하여 JSON 생성
        Map<String, Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("model", "text-embedding-ada-002");
        requestBodyMap.put("input", conversationText);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(requestBodyMap);  // 객체를 JSON 문자열로 변환

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // OpenAI API 호출
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.exchange(EAPI_URL, HttpMethod.POST, request, String.class);

        // 응답에서 벡터 값을 추출
        String embeddingVector = extractEmbeddingVector(response.getBody());

        return embeddingVector;  // 벡터 값 반환
    }

    // 대화 텍스트 생성 (GPT와의 대화 내용을 이어서 처리)
    private String buildConversationText() {
        StringBuilder conversationText = new StringBuilder();
        for (Map<String, String> message : conversationHistory) {
            conversationText.append(message.get("role")).append(": ").append(message.get("content")).append("\n");
        }
        return conversationText.toString();
    }

    // GPT의 응답에서 감정 분석 결과를 추출하는 메소드
    // 임베딩 결과에서 벡터 값을 추출하는 메소드
    private String extractEmbeddingVector(String responseBody) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(responseBody);
            JsonNode dataNode = rootNode.path("data").get(0);
            JsonNode embeddingNode = dataNode.path("embedding");

            // 벡터 값을 반환 (벡터는 배열 형태이므로, 이를 문자열로 변환하여 반환)
            return embeddingNode.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "임베딩 추출 실패";
        }
    }

    // 사용자의 메시지를 처리하고 GPT 응답 받기
    public String getBotReply(String userMessage) throws JsonProcessingException {
        // 사용자 메시지를 대화 히스토리에 추가
        Map<String, String> userMessageMap = new HashMap<>();
        userMessageMap.put("role", "user");  // 'user' 역할
        userMessageMap.put("content", userMessage);
        conversationHistory.add(userMessageMap);

        // GPT-4 API에 보낼 요청 본문 구성
        String requestBody = String.format(
                "{"
                        + "\"model\": \"gpt-4\","
                        + "\"messages\": %s,"
                        + "\"max_tokens\": 300"
                        + "}", new ObjectMapper().writeValueAsString(conversationHistory));

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // OpenAI API 호출
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.POST, request, String.class);

        // 응답에서 봇의 답변 추출
        String botReply = parseResponse(response.getBody());

        // 봇의 답변을 대화 히스토리에 추가
        Map<String, String> assistantMessageMap = new HashMap<>();
        assistantMessageMap.put("role", "assistant");  // 'assistant' 역할로 변경
        assistantMessageMap.put("content", botReply);
        conversationHistory.add(assistantMessageMap);

        return botReply;
    }

    // GPT의 응답을 파싱
    private String parseResponse(String responseBody) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(responseBody);

            JsonNode contentNode = rootNode.path("choices").get(0).path("message").path("content");
            return contentNode.asText();
        } catch (Exception e) {
            e.printStackTrace();
            return "응답 처리 중 오류가 발생했습니다.";
        }
    }
}
