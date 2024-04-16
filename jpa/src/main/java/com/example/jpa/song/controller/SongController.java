package com.example.jpa.song.controller;

import com.example.jpa.global.domain.entity.Song;
import com.example.jpa.song.dto.request.SongRequest;
import com.example.jpa.song.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/songs")
public class SongController {
    private final SongService songService;

    @GetMapping
    public List<Song> getAll(){
        return songService.getAll();
    }

    @GetMapping("/{id}")
    public Song getById(@PathVariable("id") Long id){
        return songService.getById(id);
    }


    @PostMapping
    public void save(@RequestBody SongRequest req){
        songService.save(req);
    }
}
