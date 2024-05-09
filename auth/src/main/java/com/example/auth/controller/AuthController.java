package com.example.auth.controller;

import com.example.auth.domain.request.SignInRequest;
import com.example.auth.domain.request.SignUpRequest;
import com.example.auth.domain.request.TeamRequest;
import com.example.auth.domain.response.SignInResponse;
import com.example.auth.domain.response.UserResponse;
import com.example.auth.global.utils.JwtUtil;
import com.example.auth.service.AuthService;
import com.example.auth.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;
    private final TokenService tokenService;
    private final JwtUtil jwtUtil;

    @PostMapping("signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody SignUpRequest request){
        authService.insertUser(request);
    }

    @PostMapping("signin")
    public SignInResponse signIn(@RequestBody SignInRequest request){
        return authService.signIn(request);
    }

    @PostMapping("token")
    public UserResponse getUserResponse(@RequestBody TeamRequest request){
        tokenService.isAuthenticatedTeam(request); // 무조건 true. false 는 exception 으로 잡힘
        return null;
    }
}
