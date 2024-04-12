package com.example.demo.mapper;

import com.example.demo.domain.User;
import com.example.demo.dto.request.SignInRequest;
import com.example.demo.dto.response.SignInResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper { // 이미 실행될 코드는 user-mapper 에 있으니까 interface 로 선언
    int addUser(User user);
    List<User> findByUserName(String name);
    SignInResponse signIn(SignInRequest signInRequest);
}
