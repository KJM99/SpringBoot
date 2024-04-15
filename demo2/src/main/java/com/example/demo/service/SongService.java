package com.example.demo.service;

import com.example.demo.domain.Song;
import com.example.demo.dto.request.SongRequest;

import java.util.List;

public interface SongService {
    void save(SongRequest req);
    List<Song> findAllSong();
    Song updateSong(Long id, SongRequest req);
    void deleteSong(Long id);
    Song findSongById(Long id);
    List<Song> findSongByQuery(String query);
}
