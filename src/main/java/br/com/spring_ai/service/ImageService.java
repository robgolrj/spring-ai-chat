package br.com.spring_ai.service;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    private OpenAiImageModel imageModel;

    @Autowired
    private OpenAiImageOptions openAiImageOptions;

    @Autowired
    private OpenAiImageOptions deepSeekImageOptions;


    public ImageResponse generateImage(String prompt) {
        return imageModel.call(new ImagePrompt(prompt, openAiImageOptions));
    }

    public ImageResponse generateImageDeepSeek(String prompt) {
        return imageModel.call(new ImagePrompt(prompt, deepSeekImageOptions));
    }
}
