package com.example.demo.dto.request;

import com.example.demo.domain.Song;
import lombok.*;

@RequiredArgsConstructor
@Getter
public class SongRequest {
    private final String title;
    private final String lyrics;

    public Song toEntity() {
        return Song.builder()
                .title(title)
                .lyrics(lyrics)
                .build();
    }

    public Song toEntity(Long id) {
        return Song.builder()
                .id(id)
                .title(title)
                .lyrics(lyrics)
                .build();
    }
}