package com.example.jpa.global.domain.repository;

import com.example.jpa.InitData;
import com.example.jpa.global.domain.entity.Playlist;
import com.example.jpa.global.domain.entity.User;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistRepositoryTest extends InitData {

    @Test
    void findByTitle() {
        // given
        String title = "title3";

        // when
        List<Playlist> byTitle = playlistRepository.findByTitle(title);

        // then
        // 리스트의 길이는 1개다
        Assertions.assertEquals(1, byTitle.size());
        // 관계된 유저의 username 은 user3 이다.
        Assertions.assertEquals("user3", byTitle.get(0).getUser().getUsername());
    }
}