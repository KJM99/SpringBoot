package com.example.jpa.song.service;

import com.example.jpa.global.domain.entity.Song;
import com.example.jpa.global.domain.repository.SongRepository;
import com.example.jpa.song.dto.request.SongRequest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SongServiceTest {
    @Autowired
    private SongService songService;
    @Autowired
    private SongRepository songRepository;
    Song song;

//    TDD TEST DRIVEN DEVELOPMENT 테스트 주도 개발

    @Nested
    class update{
        @Test
        void 성공() {
            // given
            SongRequest req = new SongRequest("test1", "test1");
            Long id = song.getId();
            // when
            songService.update(req, song.getId());

            // then
            Song song1 = songRepository.findById(song.getId()).get();
            assertEquals("test1", song1.getTitle());
            assertEquals("test1", song1.getLyrics());

        }

        @Test
        void 아이디가_없을_경우_실패() {
            // given
            SongRequest req = new SongRequest("test1", "test1");
            Long id = 10000L;
            // when & then
            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> songService.update(req, id));
        }
    }


    @Test
    void test2() {
        // given
//        Song song = new Song(null, "Test", "test", LocalDateTime.now());
//        songRepository.save(song);
        // when
        Song byId = songRepository.findById(song.getId()).get();

        // then
        assertEquals(song, byId);
        assertEquals(song.getId(), byId.getId());
        assertEquals("test", byId.getTitle());

        System.out.println(byId == song);
//        System.out.println(byId.getId());
//        System.out.println(song.getId());
    }









    @Transactional
    @BeforeEach
    void init(){
        song = new Song(null, "test", "test", LocalDateTime.now());
        songRepository.save(song);
    }

    @AfterEach
    void destroy(){
//        songRepository.deleteAll();
    }
}
