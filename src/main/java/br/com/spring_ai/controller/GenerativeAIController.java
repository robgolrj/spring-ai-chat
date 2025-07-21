package br.com.spring_ai.controller;

import br.com.spring_ai.service.ChatService;
import br.com.spring_ai.service.ImageService;
import br.com.spring_ai.service.RecipeService;
import org.springframework.ai.image.ImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/ai")
@RestController
public class GenerativeAIController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private ImageService imageService;



    @GetMapping("/ask-ai")
    public String getResponse(@RequestParam String prompt) {
        return chatService.getResponse(prompt);
    }

    @GetMapping("/ask-ai-options")
    public String getResponseWithOptions(@RequestParam String prompt) {
        return chatService.getResponseWithOptions(prompt);
    }

    @GetMapping("/ask-ai-deepseek")
    public String getResponseWithOptionsDeepSeek(@RequestParam String prompt) {
        return chatService.getResponseWithOptionsDeepSeek(prompt);
    }

    @GetMapping("/recipe-creator")
    public String getResponseWithOpstions(@RequestParam String ingredients,
        @RequestParam(defaultValue = "any") String cuisine,
        @RequestParam(defaultValue = "none") String dietaryRestrictions) {

        return recipeService.createRecipe(ingredients, cuisine, dietaryRestrictions);
    }


    @GetMapping("/recipe-creator-deepseek")
    public String getResponseWithOpstionsDeepSeek(@RequestParam String ingredients,
        @RequestParam(defaultValue = "any") String cuisine,
        @RequestParam(defaultValue = "none") String dietaryRestrictions) {

        return recipeService.createRecipeDeepSeek(ingredients, cuisine, dietaryRestrictions);
    }

    @GetMapping("/generate-image")
    public List<String>  generateImagens(@RequestParam String prompt) {
        ImageResponse imageResponse = imageService.generateImage(prompt);

        List<String> imageUrls = imageResponse.getResults().stream()
            .map(image -> image.getOutput().getUrl()).
            toList();

        return imageUrls;
    }

    @GetMapping("/generate-image-deepseek")
    public List<String>  generateImagensDeepSeek(@RequestParam String prompt) {
        ImageResponse imageResponse = imageService.generateImageDeepSeek(prompt);

        List<String> imageUrls = imageResponse.getResults().stream()
            .map(image -> image.getOutput().getUrl()).
                toList();

        return imageUrls;
    }
}
