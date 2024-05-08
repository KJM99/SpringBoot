package com.example.auth.global.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class JwtUtilTest {
    private JwtUtil jwtUtil =
            new JwtUtil("qwerqwerqwerqwerqwerqwerqwerqwerqwerqwer", 1000 * 60L);

    @Test
    void generateToken() {
        // given
        String email = "a@a.com";

        // when
        String token = jwtUtil.generateToken(email);

        // then
        assertNotNull(token);
        assertEquals(3, token.split("\\.").length);
    }
}