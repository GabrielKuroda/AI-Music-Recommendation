package com.kuroda.music_ai.service;

import com.kuroda.music_ai.controller.request.RecommendationRequest;
import com.kuroda.music_ai.controller.response.RecommendationResponse;
import com.kuroda.music_ai.integration.AiService;
import com.kuroda.music_ai.integration.YoutubeService;
import com.kuroda.music_ai.integration.response.AiJsonResponse;
import com.kuroda.music_ai.mapper.RecommendationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendationService {

    @Autowired
    private AiService aiService;

    @Autowired
    private YoutubeService youtubeService;

    public RecommendationResponse getRecommendation(final RecommendationRequest request) {
        AiJsonResponse aiJsonResponse = aiService.GenerateTextFromTextInput(request.getSolicitationText());
        String youtubeLink = youtubeService.getYoutubeLink(
                aiJsonResponse.getMusicName(),
                aiJsonResponse.getArtistName(),
                aiJsonResponse.getMusicAlbum());
        return RecommendationMapper.MAPPER.toResponse(aiJsonResponse, youtubeLink);
    }

}
