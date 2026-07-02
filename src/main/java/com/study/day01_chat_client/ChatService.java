package com.study.day01_chat_client;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service  // 컴포넌트 선언
public class ChatService {

    private final ChatClient chatClient;

    // Spring Boot가 구성해 줄 수 잇도록 빌더 패턴으로 주입 DI
    public ChatService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    // 비즈니스 로직 AI 모델에 연결하는
    public String chat(@RequestParam String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}
