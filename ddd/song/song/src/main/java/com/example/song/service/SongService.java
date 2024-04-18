package com.example.song.service;

import com.example.song.global.domain.entity.Song;
import com.example.song.dto.request.SongRequest;

import java.util.List;

public interface SongService {
    void save(SongRequest req);
    List<Song> getAll();
    Song getById(Long id);
    Song update(SongRequest req, Long id);

}
