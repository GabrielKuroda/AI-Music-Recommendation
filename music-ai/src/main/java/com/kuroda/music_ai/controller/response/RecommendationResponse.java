package com.kuroda.music_ai.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationResponse {

    private String musicName;

    private String artistName;

    private String musicAlbum;

    private LocalDate releaseDate;

    private String musicVideo;

}
