package com.kuroda.music_ai.integration;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class YoutubeService {

    @Value("${youtube.url}")
    private String url;

    private String apiKey;

    public YoutubeService() {
        final Dotenv dotenv = Dotenv.load();
        this.apiKey = dotenv.get("YOUTUBE_API_KEY");
    }

    public String getYoutubeLink(String music, String artist, String album) {
        String query = music + " " + artist + " " + album;

        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<>();
        params.put("query", query);
        params.put("key", apiKey);

        ResponseEntity<Map> response =
                restTemplate.getForEntity(url, Map.class, params);

        List<Map<String, Object>> items =
                (List<Map<String, Object>>) response.getBody().get("items");

        if (items == null || items.isEmpty()) {
            return null;
        }

        Map<String, Object> id = (Map<String, Object>) items.get(0).get("id");
        String videoId = (String) id.get("videoId");

        return "https://www.youtube.com/watch?v=" + videoId;
    }
}