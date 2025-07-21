package br.com.spring_ai.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.ai.deepseek.DeepSeekChatOptions;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Autowired
    private DeepSeekChatModel deepSeekChatModel;

    @Autowired
    private OpenAiChatOptions openAiChatOptions;

    @Autowired
    private DeepSeekChatOptions deepSeekChatOptions;


    public String  getResponse(String prompt) {
        return openAiChatModel.call(prompt);
    }

    public String  getResponseWithOptions(String prompt) {
        ChatResponse response = openAiChatModel.call(new Prompt(prompt, openAiChatOptions));
        return response.getResult().getOutput().getText();
    }

    public String  getResponseWithOptionsDeepSeek(String prompt) {
        ChatResponse response = deepSeekChatModel.call(new Prompt(prompt, deepSeekChatOptions));
        return response.getResult().getOutput().getText();
    }
}
