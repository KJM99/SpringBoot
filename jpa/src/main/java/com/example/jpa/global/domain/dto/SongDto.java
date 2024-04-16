package com.example.jpa.global.domain.dto;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public record SongDto (
        Long id,
        String title,
        String lyrics,
        LocalDateTime createdAt
){
}
