package com.example.auth.controller;

import com.example.auth.dto.request.UserRequest;
import com.example.auth.dto.response.UserResponse;
import com.example.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("test")
    public String test(){
        return "슬픈 개구리 페페";
    }
}
