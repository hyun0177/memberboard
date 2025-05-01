package com.prac.member.dto;

public class ChatbotDTO {
    private String sender;  // 메시지를 보낸 사람 (user 또는 bot)
    private String message;  // 실제 메시지 내용

    public ChatbotDTO() {}

    public ChatbotDTO(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
