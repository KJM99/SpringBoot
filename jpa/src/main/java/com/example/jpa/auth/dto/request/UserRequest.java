package com.example.jpa.auth.dto.request;

import com.example.jpa.global.domain.entity.User;

public record UserRequest (String username, String password, String nickname) {
    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .build();
    }
}
