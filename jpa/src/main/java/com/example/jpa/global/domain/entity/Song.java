package com.example.jpa.global.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter @AllArgsConstructor
@NoArgsConstructor @Builder
@Table(name = "SONGS")
public class Song {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SONG_ID")
    private Long id;
    @Column(name = "SONG_TITLE")
    private String title;
    @Column(name = "SONG_LYRICS")
    private String lyrics;
    @Column(name = "SONG_CREATED_AT")
    private LocalDateTime createdAt;
}
