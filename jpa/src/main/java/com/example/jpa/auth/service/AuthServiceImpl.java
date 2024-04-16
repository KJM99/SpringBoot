package com.example.jpa.auth.service;

import com.example.jpa.auth.dto.request.UserRequest;
import com.example.jpa.auth.dto.response.UserResponse;
import com.example.jpa.global.domain.entity.User;
import com.example.jpa.global.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;

    @Override
    public void save(UserRequest req) {
        userRepository.save(req.toEntity());
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(UserResponse::from).toList();
//        return userRepository.findAll();
    }
}
