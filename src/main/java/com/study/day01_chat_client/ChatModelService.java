package com.study.day01_chat_client;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.retry.RetryOperations;
import org.springframework.stereotype.Service;

// ChatModel을 사용하는 Case
@Service
public class ChatModelService {

    @Autowired
    private ChatModel chatModel;

    public String chat(String message) {
        String response = chatModel.call(message);
        return response;
    }
}
