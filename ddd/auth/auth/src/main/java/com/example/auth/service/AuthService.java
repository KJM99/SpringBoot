package com.example.auth.service;

import com.example.auth.dto.request.UserRequest;
import com.example.auth.dto.response.UserResponse;

import java.util.List;

public interface AuthService {
    void save(UserRequest req);
    List<UserResponse> getAll();
}
