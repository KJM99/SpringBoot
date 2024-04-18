package com.example.auth.global.domain.repository;

import com.example.auth.global.domain.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
