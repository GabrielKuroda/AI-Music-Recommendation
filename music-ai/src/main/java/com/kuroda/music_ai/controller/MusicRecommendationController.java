package com.kuroda.music_ai.controller;

import com.kuroda.music_ai.controller.request.RecommendationRequest;
import com.kuroda.music_ai.controller.response.RecommendationResponse;
import com.kuroda.music_ai.service.RecommendationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/music")
public class MusicRecommendationController {

    @Autowired
    private RecommendationService service;

    @PostMapping("/recommend")
    public ResponseEntity<RecommendationResponse> getRecommendation(@RequestBody @Valid RecommendationRequest request) {
        RecommendationResponse recommendation = service.getRecommendation(request);
        return ResponseEntity.ok(recommendation);
    }

}
