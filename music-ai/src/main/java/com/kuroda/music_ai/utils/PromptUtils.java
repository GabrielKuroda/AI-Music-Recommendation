package com.kuroda.music_ai.utils;

import org.springframework.stereotype.Component;

@Component
public class PromptUtils {

    public static final String RECOMMENDATION_PROMPT =
            "Você é um serviço backend e DEVE responder apenas com um JSON válido.\n" +
            "\n" +
            "REGRAS OBRIGATÓRIAS:\n" +
            "- NÃO escreva texto explicativo\n" +
            "- NÃO use markdown\n" +
            "- NÃO use blocos de código\n" +
            "- NÃO escreva nada antes ou depois do JSON\n" +
            "- NÃO inclua comentários\n" +
            "- NÃO inclua campos extras\n" +
            "- NÃO altere os nomes dos campos\n" +
            "- NÃO retorne valores nulos\n" +
            "\n" +
            "FORMATO EXATO DA RESPOSTA:\n" +
            "{\n" +
            "  \"musicName\": \"string\",\n" +
            "  \"artistName\": \"string\",\n" +
            "  \"musicAlbum\": \"string\",\n" +
            "  \"musicGenre\": \"string\",\n" +
            "  \"releaseDate\": \"yyyy-MM-dd\"\n" +
            "}\n" +
            "\n" +
            "Com base no texto abaixo, gere UMA recomendação de música seguindo exatamente o formato acima.\n" +
            "\n" +
            "TEXTO DE ENTRADA:\n" +
            "%s";
}
