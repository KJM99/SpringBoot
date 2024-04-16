package com.example.jpa.auth.service;

import com.example.jpa.auth.dto.request.UserRequest;
import com.example.jpa.auth.dto.response.UserResponse;
import com.example.jpa.global.domain.entity.User;

import java.util.List;
import java.util.Map;

public interface AuthService {
    void save(UserRequest req);
    List<UserResponse> getAll();
}
