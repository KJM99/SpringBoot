package com.example.auth.service;

import com.example.auth.domain.entity.User;
import com.example.auth.domain.entity.UserRepository;
import com.example.auth.domain.request.SignUpRequest;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void insertUser(SignUpRequest signUpRequest) {
        // 1. 유저가 있는지 찾아보고
        Optional<User> byEmail = userRepository.findByEmail(signUpRequest.email());
        // 2-1. 있으면 error
        if(byEmail.isPresent()) throw new IllegalArgumentException();
        // 2-2. 없으면 insert
        String encodedPassword = passwordEncoder.encode(signUpRequest.password());
        User user = signUpRequest.toEntity(encodedPassword);
        userRepository.save(user);
    }
}
