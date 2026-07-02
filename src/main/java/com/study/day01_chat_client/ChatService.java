package com.study.day01_chat_client;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.google.genai.GoogleGenAiChatOptions;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service  // 컴포넌트 선언
public class ChatService {

    private final ChatClient chatClient;

    // Spring Boot가 구성해 줄 수 잇도록 빌더 패턴으로 주입 DI
    public ChatService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    // 일반 응답
    public String chat(@RequestParam String message) {
        return chatClient.prompt()
                .user(message)    // User Prompt 사용자의 실제 질문
                .call()
                .content();
    }

    // 교사 역할 응답
    public String teacher(@RequestParam String message) {
        return chatClient.prompt()
                .system("""
                        당신은 Java, Spring Boot, Spring AI를 가르치는
                        선생님입니다. 초보 학습자에게 설명하듯이 답변 해주세요.
                        핵심 개념, 예시, 주의할 점을 포함하여야 합니다.
                        친절하게 한국어로 설명해주세요.
                        """)   // System Prompt 역할을 지시
                .user(message)    // User Prompt 사용자의 실제 질문
                .call()
                .content();
    }

    // 기준을 강화한 옵션 챗
    public String safeChat(String message) {
        return chatClient.prompt()
                .user(message)
                .options(GoogleGenAiChatOptions.builder()
                        .temperature(0.2)   // 기준 강화
                )
                .call()
                .content();
    }
}




