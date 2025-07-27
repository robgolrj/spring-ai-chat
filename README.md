# 🧠 Spring AI Chat API

Este é um projeto Java utilizando **Spring Boot** e a biblioteca **Spring AI**, que expõe uma API REST para interações em linguagem natural com modelos de IA. A aplicação permite:

* Responder perguntas com texto (OpenAI e DeepSeek)
* Gerar receitas com base em ingredientes, culinária e restrições alimentares
* Criar imagens a partir de prompts (OpenAI e DeepSeek)

---

## 🚀 Funcionalidades

### 🔹 Chat com IA

- `GET /ai/ask-ai?prompt=texto`  
  Responde perguntas usando o modelo OpenAI.

- `GET /ai/ask-ai-options?prompt=texto`  
  Responde perguntas com opções personalizadas do modelo OpenAI.

- `GET /ai/ask-ai-deepseek?prompt=texto`  
  Responde perguntas usando o modelo DeepSeek.

### 🔹 Criação de receitas

- `GET /ai/recipe-creator?ingredients=ingredientes&cuisine=tipo&dietaryRestrictions=restricoes`  
  Gera receitas com base nos parâmetros usando OpenAI.

- `GET /ai/recipe-creator-deepseek?ingredients=ingredientes&cuisine=tipo&dietaryRestrictions=restricoes`  
  Gera receitas usando DeepSeek.

### 🔹 Geração de imagens

- `GET /ai/generate-image?prompt=texto`  
  Gera imagens com DALL·E (OpenAI).

- `GET /ai/generate-image-deepseek?prompt=texto`  
  Gera imagens com Janus-Pro (DeepSeek).

---

## ⚙️ Tecnologias Utilizadas

* Java 17+
* Spring Boot 3.x
* Spring AI
* OpenAI e DeepSeek (Chat e Image Models)
* Maven

---

## 🧩 Estrutura de Pacotes

```
br.com.spring_ai
├── controller           # Controladores REST
│   ├── GenerativeAIController.java
│   ├── InfoController.java
│   └── GobalAdviceController.java
├── service              # Serviços de negócio
├── OpenAiConfig.java    # Configuração dos modelos OpenAI/DeepSeek
├── WebConfig.java       # Configuração de CORS
├── SpringAiApplication.java
```

---

## 🛠️ Configuração

1. **Pré-requisitos:**
   * Java 17+
   * Maven
   * Chaves de API válidas para OpenAI e DeepSeek

2. **Variáveis de ambiente:**

   ```shell
   set OPENAI_API_KEY=your_openai_key
   set DEEP_SEEK_API_KEY=your_deepseek_key
   ```

   Ou configure no arquivo `src/main/resources/application.yaml`:

   ```yaml
   spring:
     ai:
       openai:
         api-key: ${OPENAI_API_KEY}
       deepseek:
         api-key: ${DEEP_SEEK_API_KEY}
   ```

---

## 🧪 Testando a API

Ferramentas recomendadas:

* Postman
* Insomnia
* curl

Exemplo:

```shell
curl "http://localhost:8080/ai/ask-ai?prompt=Qual%20o%20significado%20da%20vida?"
```

---

## 📦 Build & Execução

```shell
mvn clean install
mvn spring-boot:run
```

Ou para criar o JAR:

```shell
mvn clean package
java -jar target/spring-ai-*.jar
```

---

## 🌐 CORS

A aplicação permite requisições de `http://localhost:8080/` e `http://localhost:3000/` para facilitar o desenvolvimento front-end.

---

## 📌 Observações

* Modelos padrão: `gpt-4.1-nano` (chat OpenAI), `dall-e-3` (imagem OpenAI), `janus-pro` (imagem DeepSeek).
* Temperatura configurada em 0.4 para respostas objetivas.
* Tratamento global de erros via `GobalAdviceController`.
* Página inicial disponível em `/` com links para todos os endpoints.
* Projeto modular e extensível.

---

## 📝 Licença

Projeto de exemplo para fins educacionais.
