package com.kuroda.music_ai.integration.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AiResponse {

    private String musicName;

    private String artist;

    private String musicAlbum;

    private LocalDate releaseDate;
}

