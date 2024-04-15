package com.example.demo.domain;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder @Getter @Setter
public class Song {
    private Long id;
    private String title;
    private String lyrics;
    private LocalDateTime createdAt;
}
