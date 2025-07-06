package br.com.spring_ai.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RecipeService {
    @Autowired
    private ChatModel chatModel;

    @Autowired
    private OpenAiChatOptions openAiChatOptions;

    public String createRecipe(String ingredients,
        String cuisine, String dietaryRestrictions) {

        var template = """
            I want to create a recipe using the following ingredients: {ingredients}.
            The cuisine type I prefer is {cuisine}.
            Please consider the following dietary restrictions: {dietaryRestrictions}.
            Please provide me with a detailed recipe including title, list of ingredients, and cooking instructions.        
            """;
        PromptTemplate promptTemplate = new PromptTemplate(template);
        Map<String, Object> params = Map.of(
            "ingredients", ingredients,
            "cuisine", cuisine,
            "dietaryRestrictions", dietaryRestrictions
        );
        Prompt prompt = promptTemplate.create(params, openAiChatOptions);
        return chatModel.call(prompt).getResult().getOutput().getText();
    }
}
