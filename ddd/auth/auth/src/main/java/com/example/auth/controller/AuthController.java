package com.example.auth.controller;

import com.example.auth.api.FeignPlaylist;
import com.example.auth.config.JwtTokenUtils;
import com.example.auth.config.TokenInfo;
import com.example.auth.dto.request.LoginRequest;
import com.example.auth.dto.request.SignupRequest;
import com.example.auth.dto.request.UpdateRequest;
import com.example.auth.dto.request.UserRequest;
import com.example.auth.dto.response.UserResponse;
import com.example.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController {
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthService authService;
    private final FeignPlaylist feignPlaylist;


//    header 에 Authorization 이라는 field 에 값을 넣어줌 : Bearer ~~~
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){ // 컨트롤러는 코드가 짧은 것이 좋음
        return authService.login(request);
    }

    @PostMapping("signup")
    public void signup(@RequestBody SignupRequest request){
        authService.signUp(request);
    }

    // 토큰 안에 있는 내 데이터를 까서 보여주는 것
    @GetMapping("/me")
    public TokenInfo getMe(@RequestHeader("Authorization") String bearerToken){
        String token = bearerToken.substring(7);
        return jwtTokenUtils.parseToken(token);
    }

    @GetMapping("/play")
    public Object getPlaylist(){
        return feignPlaylist.getAll();
    }

    @PutMapping
    public void updatePlayList(@RequestHeader("Authorization") String bearerToken, @RequestBody UpdateRequest request){
        TokenInfo token = jwtTokenUtils.parseToken(bearerToken.substring(7));
        authService.update(token.id(), request);
    }

    @GetMapping
    public List<UserResponse> getAll(@RequestHeader("Authorization") String bearerToken){
        // "Bearer " ~~~ 에서 문제가 생기니 앞 부분을 잘라줌
        String token = bearerToken.substring(7);
        jwtTokenUtils.parseToken(token); // 검증


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
