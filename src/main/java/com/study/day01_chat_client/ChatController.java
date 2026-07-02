package com.study.day01_chat_client;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 요청과 응답만 담당
@RestController  // REST API 방식의 컨트롤러
public class ChatController {

//    서비스 레이어 의존성 주입
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/api/chat")
    public String chat(@RequestParam String message) {
        return chatService.chat(message);
    }

    @GetMapping("/api/teacher")
    public String teacher(@RequestParam String message) {
        return chatService.teacher(message);
    }
}
