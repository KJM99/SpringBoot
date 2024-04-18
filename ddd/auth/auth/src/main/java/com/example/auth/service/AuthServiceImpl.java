package com.example.auth.service;

import com.example.auth.dto.request.UserRequest;
import com.example.auth.dto.response.UserResponse;
import com.example.auth.global.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
