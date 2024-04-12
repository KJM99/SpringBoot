package com.example.demo.controller;

import com.example.demo.dto.request.SignInRequest;
import com.example.demo.dto.request.UserRequest;
import com.example.demo.dto.response.SignInResponse;
import com.example.demo.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
//@AllArgsConstructor // lombok 으로 생성자 대체 가능
@RequiredArgsConstructor // final 붙었으니까 Required~
public class AuthController {

//    @Autowired
    private final AuthService authService;

//    public AuthController(AuthService authService) {
//        this.authService = authService;
//    } // 생성자 사용하는거 굉장히 불편함

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody UserRequest req){
//        System.out.println(req.toString());
        authService.signUP(req);
    }

    // 받아올 것 먼저 생각
    // 받아올 것 : username, password
    // response userId, userNickname
    @PostMapping("/sign-in")
    public SignInResponse signIn(@RequestBody SignInRequest req){
//        user - id
        return authService.signIn(req);

    }
}
