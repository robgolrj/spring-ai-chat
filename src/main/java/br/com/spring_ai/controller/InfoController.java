package br.com.spring_ai.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping ("/")
    public String home() {
        return """
            <!DOCTYPE html>
            <html lang="pt-br">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Spring AI Application</title>
                </head>
                <body>
                    <h1>Spring AI Application</h1>
                    <p>Sua aplicação subi com sucesso!</p>
                    <p>Acesse os endpoints disponíveis:</p>
                    <ul>
                        <li><a href="/ai/ask-ai?prompt=Seu+texto+de+pergunta">/ai/ask-ai?prompt=Seu+texto+de+pergunta</a></li>
                        <li><a href="/ai/ask-ai-options?prompt=Seu+texto+de+pergunta">/ai/ask-ai-options?prompt=Seu+texto+de+pergunta</a></li>
                        <li><a href="/ai/ask-ai-deepseek?prompt=Seu+texto+de+pergunta">/ai/ask-ai-deepseek?prompt=Seu+texto+de+pergunta</a></li>
                        <li><a href="/ai/recipe-creator?ingredients=Seu+ingrediente&cuisine=Sua+cuisine&dietaryRestrictions=Suas+restrições">/ai/recipe-creator?ingredients=Seu+ingrediente&cuisine=Sua+cuisine&dietaryRestrictions=Suas+restrições</a></li>
                        <li><a href="/ai/recipe-creator-deepseek?ingredients=Seu+ingrediente&cuisine=Sua+cuisine&dietaryRestrictions=Suas+restrições">/ai/recipe-creator-deepseek?ingredients=Seu+ingrediente&cuisine=Sua+cuisine&dietaryRestrictions=Suas+restrições</a></li>
                        <li><a href="/ai/generate-image?prompt=Seu+texto+de+imagem">/ai/generate-image?prompt=Seu+texto+de+imagem</a></li>
                        <li><a href="/ai/generate-image-deepseek?prompt=Seu+texto+de+imagem">/ai/generate-image-deepseek?prompt=Seu+texto+de+imagem</a></li>                        
                    </ul>
                </body>
            </html>
            """;
    }
}
