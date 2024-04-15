package com.example.demo.mapper;

import com.example.demo.domain.Song;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SongMapper {
    int insertSong(Song song);
    int updateSong(Song song);
    int deleteSong(long id);
    Song findSongById(long id);
    List<Song> findAllSongs();
    List<Song> findSongByQuery(@Param("query") String query);
}
