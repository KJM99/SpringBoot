package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.request.SignInRequest;
import com.example.demo.dto.request.UserRequest;
import com.example.demo.dto.response.SignInResponse;
import com.example.demo.exception.ExistUsernameException;
import com.example.demo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserMapper userMapper;

    public void signUP(UserRequest req){
        // 디비에 있는 유저인지 찾고 없으면 insert
//        User user = // UserRequest 로 옮김
//                new User(null,
//                        req.getName(),
//                        req.getPassword(),
//                        req.getNickname()
//                );
        List<User> byUserName = userMapper.findByUserName(req.getName());
        // 있으면 처리
        if(!byUserName.isEmpty()) throw new ExistUsernameException();
        // 없으면 insert
        userMapper.addUser(req.toEntity());
    }

//    내가 하다가 실패
//    public SignInResponse singIn(SignInRequest req){
//        SignInResponse signInResponse = userMapper.signIn(req);
//        System.out.println(signInResponse.id() + " " + signInResponse.nickname());
//        return signInResponse;
//    }

    public SignInResponse signIn(SignInRequest req) {
        List<User> findByName = userMapper.findByUserName(req.username());
        if(findByName.isEmpty()) throw new IllegalArgumentException("Failed Login");
        User user = findByName.get(0);
        if(!user.getPassword().equals(req.password())) throw new IllegalArgumentException("Failed Login");
        return new SignInResponse(user.getId(), user.getNickname());
    }
}
