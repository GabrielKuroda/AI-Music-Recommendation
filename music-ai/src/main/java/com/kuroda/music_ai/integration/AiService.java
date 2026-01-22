package com.kuroda.music_ai.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.kuroda.music_ai.integration.response.AiJsonResponse;
import com.kuroda.music_ai.utils.PromptUtils;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    @Value("${ai.model}")
    private String geminiModel;

    private String apiKey;

    public AiService() {
        final Dotenv dotenv = Dotenv.load();
        this.apiKey = dotenv.get("GEMINI_API_KEY");
    }

    public AiJsonResponse GenerateTextFromTextInput (final String promptInfo){
        Client client = Client.builder().apiKey(apiKey).build();

        GenerateContentResponse response =
                client.models.generateContent(
                        geminiModel,
                        generatePrompt(promptInfo),
                        null);

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            return mapper.readValue(response.text(), AiJsonResponse.class);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter JSON da IA", e);
        }
    }

    private String generatePrompt(final String promptText) {
        return String.format(
                PromptUtils.RECOMMENDATION_PROMPT,
                promptText
        );
    }

}
