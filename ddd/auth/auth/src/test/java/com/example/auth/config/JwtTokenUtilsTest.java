package com.example.auth.config;

import com.example.auth.global.domain.entity.User;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtTokenUtilsTest {
    @Autowired JwtTokenUtils jwtTokenUtils;
    @Test
    void createToken() {
        String token = jwtTokenUtils.createToken(
                new User(1l, "1", "1", "1", null)
        );
        System.out.println(token);
        Assertions.assertNotNull(token);
    }
    @Test
    void parseToken(){

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwibmlja25hbWUiOiIxIiwiZXhwIjoxNzEzNTAyOTA4fQ.D7ifUMCOsw2M5DyFa2erSbwHq8CvAbSdNvdDE9FYv9I";
        Assertions.assertThrows(
                ExpiredJwtException.class,
                ()->jwtTokenUtils.parseToken(token));
    }
    @Test
    void parseToken1(){
        String token = jwtTokenUtils.createToken(
                new User(1l, "1", "1", "1", null)
        );
        Assertions.assertNotNull(jwtTokenUtils.parseToken(token));
    }
    @Test
    void parseToken2(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwibmlja25hbWUiOiIxIiwiZXhwIjoxNzEzNTAyOTA4fQ.Iqq-CpDu6uf3LjcFdKoTZDH7uUB6GQozoN8DuKK86n0";
        assertThrows(SignatureException.class,()-> {
            jwtTokenUtils.parseToken(token);
        });
    }
}