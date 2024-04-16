package com.example.jpa.global.domain.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;

public record PlaylistDto(
        Long id,
        String plTitle
) {
}
