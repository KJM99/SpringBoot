package com.example.jpa.song.dto.request;

import com.example.jpa.global.domain.entity.Song;

import java.time.LocalDateTime;

public record SongRequest(String title, String lyrics) {

    public Song toEntity(){
        return Song.builder()
                .title(title)
                .lyrics(lyrics)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
