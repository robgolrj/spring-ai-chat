package br.com.spring_ai;

import org.springframework.ai.deepseek.DeepSeekChatOptions;
import org.springframework.ai.deepseek.api.DeepSeekApi;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAiConfig {

    @Bean
    public OpenAiChatOptions openAiChatOptions() {
        return OpenAiChatOptions.builder()
            .model("gpt-4.1-nano")
            .temperature(0.4)
            .build();
    }
    @Bean
    public OpenAiImageOptions openAiImageOptions() {
        return OpenAiImageOptions.builder()
            .model("dall-e-3")
            .quality("hd")
            .N(1)
            .height(1024)
            .width(1024)
            .build();
    }

    @Bean
    public DeepSeekChatOptions deepSeekChatOptions() {
        return DeepSeekChatOptions.builder()
            .model(DeepSeekApi.ChatModel.DEEPSEEK_CHAT.getValue())
            .temperature(0.4)
            .build();
    }

    @Bean
    public OpenAiImageOptions deepSeekImageOptions() {
        return OpenAiImageOptions.builder()
            .model("janus-pro")
            .quality("hd")
            .N(1)
            .height(1024)
            .width(1024)
            .build();
    }

}
