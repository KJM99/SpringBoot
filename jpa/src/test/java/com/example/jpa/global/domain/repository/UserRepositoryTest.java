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

class UserRepositoryTest extends InitData {

    @Test
    void findByUsername() {
        // given
        String user = "user1";

        // when
        List<User> byName = userRepository.findByUsername(user);

        // then
        Assertions.assertEquals(1, byName.size());
    }

    @Test
    void findByNicknameContainingOrderByIdDesc() {
        // given
        String query = "user";
        // when
        List<User> byNicknameContainingOrderByIdDesc = userRepository.findByNicknameContainingOrderByIdDesc(query);
        // then
        Assertions.assertEquals(10,byNicknameContainingOrderByIdDesc.size());
        Assertions.assertEquals("user9", byNicknameContainingOrderByIdDesc.get(0).getNickname());
    }
}