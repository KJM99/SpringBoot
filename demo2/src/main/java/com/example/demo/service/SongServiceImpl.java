package com.example.demo.service;

import com.example.demo.domain.Song;
import com.example.demo.dto.request.SongRequest;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.SongMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {
    private final SongMapper songMapper;

    @Override
    public void save(SongRequest req){
        songMapper.insertSong(req.toEntity());
    }

    @Override
    public List<Song> findAllSong() {
        return songMapper.findAllSongs();
    }

    @Override
    public Song updateSong(Long id, SongRequest req) {
        Song songById = findSongById(id);

        // songByID가 null 인지 판단
        if(songById == null) throw new NotFoundException("SONG");

        // 여기서부터는 songById가 무조건 존재. null 이었으면 위에서 끝났음
        if(songById.getTitle().equals(req.getTitle())
                && songById.getLyrics().equals(req.getLyrics()))
            return new Song();

        Song entity = req.toEntity(id);
        songMapper.updateSong(entity);
        return entity;
    }

    @Override
    public void deleteSong(Long id) {
        songMapper.deleteSong(id);
    }

    @Override
    public Song findSongById(Long id) {
        return songMapper.findSongById(id);
    }

    @Override
    public List<Song> findSongByQuery(String query) {
        return songMapper.findSongByQuery("%" + query + "%");
    }

}
