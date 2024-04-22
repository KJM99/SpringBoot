package com.example.auth.service;

import com.example.auth.dto.request.LoginRequest;
import com.example.auth.dto.request.SignupRequest;
import com.example.auth.dto.request.UserRequest;
import com.example.auth.dto.response.UserResponse;

import java.util.List;

public interface AuthService {
    void save(UserRequest req);
    List<UserResponse> getAll();
    void signUp(SignupRequest request);
    String login(LoginRequest request);
}
