package com.example.auth.service;

import com.example.auth.domain.request.SignUpRequest;

public interface AuthService {
    void insertUser(SignUpRequest signUpRequest);

}
