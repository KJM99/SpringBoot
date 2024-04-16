package com.example.jpa.global.domain.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public record UserDto (
        Long id,
        String nickname
){
}
