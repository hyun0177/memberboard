package com.prac.member.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prac.member.dto.ChatbotDTO;
import com.prac.member.service.ChatbotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080")
@Controller
public class ChatbotController {

    @Autowired
    private ChatbotService chatbotService;

    @GetMapping("/chatbot")
    public String showChatPage() {
        return "chatbot/main";  // chatbot.html로 렌더링
    }

    @PostMapping("/chatbot/ask")
    @ResponseBody
    public ChatbotDTO handleUserMessage(@RequestBody ChatbotDTO userMessage) throws JsonProcessingException {
        // GPT에 사용자 메시지를 보내고 응답을 받음
        String botReply = chatbotService.getBotReply(userMessage.getMessage());

        // 봇 응답을 DTO로 감싸서 반환
        return new ChatbotDTO("봇", botReply);  // 봇 응답 객체 반환
    }

    // 감정 분석 요청
    @PostMapping("/chatbot/emotion")
    @ResponseBody
    public ResponseEntity<Map<String, String>> getEmotion() throws JsonProcessingException {
        String emotion = chatbotService.getEmotionAnalysis();  // 감정 분석 수행
        System.out.println(emotion);
        Map<String, String> response = Map.of("emotion", emotion);  // 감정 분석 결과 반환
        return ResponseEntity.ok(response);
    }

    // 대화 히스토리 초기화
    @RequestMapping(value = "/chatbot/reset", method = RequestMethod.POST)
    public ResponseEntity<String> resetConversation() {
        chatbotService.resetConversationHistory(); // 히스토리 초기화
        return ResponseEntity.ok("대화 히스토리가 초기화되었습니다.");
    }
}
