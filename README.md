# 🧠 Spring AI Chat API

Este é um projeto Java utilizando **Spring Boot** e a biblioteca **Spring AI**, que expõe uma API REST para interações em linguagem natural com modelos de IA. A aplicação permite:

* Responder perguntas com texto,
* Gerar receitas com base em ingredientes e restrições,
* Criar imagens a partir de prompts.

---

## 🚀 Funcionalidades

### 🔹 `/ai/ask-ai`

Responde uma pergunta simples baseada em linguagem natural.

```http
GET /ai/ask-ai?prompt=Qual%20a%20capital%20da%20França?
```

### 🔹 `/ai/ask-ai-options`

Responde uma pergunta utilizando opções personalizadas do modelo (como temperatura e modelo especificado).

```http
GET /ai/ask-ai-options?prompt=Me%20explique%20a%20teoria%20da%20relatividade
```

### 🔹 `/ai/recipe-creator`

Gera uma receita com base em ingredientes, tipo de culinária e restrições alimentares.

```http
GET /ai/recipe-creator?ingredients=tomate,queijo,pão&cuisine=italiana&dietaryRestrictions=vegetariano
```

### 🔹 `/ai/generate-image`

Gera imagens a partir de um prompt de texto usando o modelo DALL·E.

```http
GET /ai/generate-image?prompt=uma%20cidade%20futurista%20à%20noite
```

---

## ⚙️ Tecnologias Utilizadas

* Java 17+
* Spring Boot 3.x
* [Spring AI](https://docs.spring.io/spring-ai/)
* OpenAI (Chat e Image Models)
* REST API

---

## 🧩 Estrutura de Pacotes

```
br.com.spring_ai
├── controller           # Controladores REST
├── service              # Serviços de negócio com uso da IA
├── OpenAiConfig.java    # Configuração dos modelos OpenAI
```

---

## 🛠️ Configuração

1. **Pré-requisitos:**

   * Java 17+
   * Maven ou Gradle
   * Chave de API da OpenAI (definir via variável de ambiente ou application.properties)

2. **Dependência principal:**
   O projeto deve conter a dependência do Spring AI no `pom.xml` ou `build.gradle`.

3. **Variáveis de ambiente esperadas:**

   ```bash
   SPRING_AI_OPENAI_API_KEY=your-api-key
   ```

---

## 🧪 Testando a API

Recomenda-se usar ferramentas como:

* [Postman](https://www.postman.com/)
* [Insomnia](https://insomnia.rest/)
* `curl`

Exemplo com curl:

```bash
curl "http://localhost:8080/ai/ask-ai?prompt=Qual%20o%20significado%20da%20vida?"
```

---

## 📦 Build & Execução

```bash
./mvnw spring-boot:run
```

Ou para criar o JAR:

```bash
./mvnw clean package
java -jar target/spring-ai-chat-api.jar
```

---

## 📌 Observações

* O projeto usa por padrão o modelo `gpt-4.1-nano` para conversação e `dall-e-3` para geração de imagens.
* A temperatura está configurada como 0.4 para respostas mais objetivas.
* O sistema é modular e pode ser estendido facilmente com novos endpoints.
