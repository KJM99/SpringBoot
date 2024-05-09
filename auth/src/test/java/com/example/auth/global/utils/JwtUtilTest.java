package com.example.auth.global.utils;

import static org.junit.jupiter.api.Assertions.*;

import io.jsonwebtoken.JwtException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class JwtUtilTest {
    private final JwtUtil jwtUtil =
            new JwtUtil("qwerqwerqwerqwerqwerqwerqwerqwerqwerqwer", 1000 * 1L);

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

    @Nested
    class getByEmailFromTokenAndValidate{
        @Test
        void 성공() {
            // given
            String email = "a@a.com";
            String token = jwtUtil.generateToken(email);

            // when
            String answer = jwtUtil.getByEmailFromTokenAndValidate(token);

            // then
            assertNotNull(answer);
            assertEquals(email, answer);
        }

        @Test
        void 시간_만료() throws InterruptedException {
            // given
            String email = "a@a.com";
            String token = jwtUtil.generateToken(email);
            Thread.sleep(1000L);
            // when & then
            assertThrows(JwtException.class, ()->{
                jwtUtil.getByEmailFromTokenAndValidate(token);
            });
        }
    }
}