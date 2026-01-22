package com.kuroda.music_ai.integration.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AiJsonResponse {

    private String musicName;
    private String artistName;
    private String musicAlbum;
    private String musicGenre;
    private LocalDate releaseDate;
}
