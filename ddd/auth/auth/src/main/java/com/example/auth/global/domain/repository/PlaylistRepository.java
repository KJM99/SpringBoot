package com.example.auth.global.domain.repository;

import com.example.auth.global.domain.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
//    named query
//    select * from playlists where playlist_title = ?
    List<Playlist> findByTitle(String title);

//    jpa 에서 쿼리는 jpql 문법
//    entity query
//    select * from playlist
//    join user on playlist.user_id = user_id
    @Query("select pl from Playlist pl " +
            "join fetch pl.user u " +
            "where u.nickname like concat('%',:nickname,'%')")
    List<Playlist> findAllWithUsers(@Param("nickname") String nickname);
}
