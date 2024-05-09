package com.example.auth.global.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final Long expiration;
    private final SecretKey secretKey;

    public String generateToken(String email) {
        String token = Jwts.builder()
            .subject(email)
            .expiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(secretKey)
            .compact();

        return token;
    }

    public String getByEmailFromTokenAndValidate(String token) {
        Claims payload = (Claims) Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parse(token)
            .getPayload();

        return payload.getSubject();
    }

    // 밑에 생성자 있어요











    public JwtUtil(
        @Value("${jwt.secret}") String secret,
        @Value("${jwt.expiration}") Long expiration
    ) {
        this.expiration = expiration;
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
    }
}
