package com.example.auth.global.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final String secret;
    private final Long expiration;

    public String generateToken(String email) {
        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes());
        String token = Jwts.builder()
            .subject(email)
            .expiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(secretKey)
            .compact();

        return token;
    }

    // 밑에 생성자 있어요











    public JwtUtil(
        @Value("${jwt.secret}") String secret,
        @Value("${jwt.expiration}") Long expiration
    ) {
        this.secret = secret;
        this.expiration = expiration;
    }
}
