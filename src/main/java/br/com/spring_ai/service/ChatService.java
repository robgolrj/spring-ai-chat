package br.com.spring_ai.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private ChatModel chatModel;

    @Autowired
    private OpenAiChatOptions openAiChatOptions;


    public String  getResponse(String prompt) {
        return chatModel.call(prompt);
    }

    public String  getResponseWithOptions(String prompt) {
        ChatResponse response = chatModel.call(new Prompt(prompt, openAiChatOptions));
        return response.getResult().getOutput().getText();
    }
}
