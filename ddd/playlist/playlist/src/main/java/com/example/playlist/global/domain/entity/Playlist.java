package com.example.playlist.global.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PLAYLISTS")
@Getter @AllArgsConstructor @NoArgsConstructor
@Builder
public class Playlist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAYLIST_ID")
    private Long id;
    @Column(name = "PLAYLIST_TITLE")
    private String title;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USER_NICKNAME")
    private String nickname;
}
