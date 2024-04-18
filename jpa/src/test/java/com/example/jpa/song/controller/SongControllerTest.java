package com.example.jpa.song.controller;

import com.example.jpa.InitData;
import com.example.jpa.global.domain.entity.Song;
import com.example.jpa.global.domain.entity.User;
import com.example.jpa.global.domain.repository.SongRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc // 컨트롤러를 테스트하기 위해서는 받아줘야함. Talend 같은거
class SongControllerTest extends InitData {

    @Autowired
    private MockMvc mockMvc;
    String baseUrl = "/api/vi/songs/";



//    url: /api/v1/songs
//    method: GET
//    성공: 200 - obj 가 나옴
//    실패: 200 - 빈 obj 가 나옴
    @Test
    void getById() throws Exception {
        // given: 변수
        // 여기서는 song id
        Long id = song.getId();

        // when
        ResultActions perform = mockMvc.perform(
                get(baseUrl + id)
        );

        // then
        perform.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(song.getId()))
                .andExpect(jsonPath("$.title").value(song.getTitle()))
                .andExpect(jsonPath("$.lyrics").value(song.getLyrics()))
                .andExpect(jsonPath("$.createdAt").isNotEmpty());

    }
}