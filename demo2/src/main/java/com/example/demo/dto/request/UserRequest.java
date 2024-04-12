package com.example.demo.dto.request;

import com.example.demo.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserRequest {
    private final String name;
    private final String password;
    private final String nickname;

    public User toEntity() {
        return User.builder()
                .name(name)
                .nickname(nickname)
                .password(password)
                .build();
    }
}

// 필수 : required
