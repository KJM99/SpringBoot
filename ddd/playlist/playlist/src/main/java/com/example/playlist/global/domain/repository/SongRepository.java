package com.example.playlist.global.domain.repository;

import com.example.playlist.global.domain.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
