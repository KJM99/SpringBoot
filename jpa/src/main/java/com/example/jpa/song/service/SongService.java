package com.example.jpa.song.service;

import com.example.jpa.global.domain.entity.Song;
import com.example.jpa.song.dto.request.SongRequest;

import java.util.List;
import java.util.Map;

public interface SongService {
    void save(SongRequest req);
    List<Song> getAll();
    Song getById(Long id);
    Song update(SongRequest req, Long id);

}
