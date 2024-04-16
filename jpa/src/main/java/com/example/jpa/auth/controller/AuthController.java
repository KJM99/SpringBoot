package com.example.jpa.auth.controller;

import com.example.jpa.auth.dto.request.UserRequest;
import com.example.jpa.auth.dto.response.UserResponse;
import com.example.jpa.auth.service.AuthService;
import com.example.jpa.global.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @GetMapping
    public List<UserResponse> getAll(){
        return authService.getAll();
    }

    @PostMapping
    public void save(@RequestBody UserRequest req){
        authService.save(req);
    }
}
