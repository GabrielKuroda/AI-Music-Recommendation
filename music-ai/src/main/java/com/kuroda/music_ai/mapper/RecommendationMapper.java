package com.kuroda.music_ai.mapper;

import com.kuroda.music_ai.controller.response.RecommendationResponse;
import com.kuroda.music_ai.integration.response.AiJsonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

@Mapper
public interface RecommendationMapper {

    RecommendationMapper MAPPER = Mappers.getMapper(RecommendationMapper.class);

    @Mapping(target = "musicVideo", source = "youtubeUrl")
    RecommendationResponse toResponse(AiJsonResponse aiJsonResponse, String youtubeUrl);

}
