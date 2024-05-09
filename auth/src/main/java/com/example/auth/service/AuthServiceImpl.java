package com.example.auth.service;

import com.example.auth.domain.entity.User;
import com.example.auth.domain.entity.UserRepository;
import com.example.auth.domain.request.SignInRequest;
import com.example.auth.domain.request.SignUpRequest;
import com.example.auth.domain.response.SignInResponse;
import com.example.auth.exception.ExistedUserException;
import com.example.auth.global.utils.JwtUtil;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService, UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }

    @Override
    @Transactional
    public void insertUser(SignUpRequest request) {
        log.info("Insert user");
        // 1. 유저가 있는지 찾아보고
        Optional<User> byEmail = userRepository.findByEmail(request.email());
        // 2-1. 있으면 error
        if(byEmail.isPresent()) throw new ExistedUserException(request.email());
        // 2-2. 없으면 insert
        String encodedPassword = passwordEncoder.encode(request.password());
        User user = request.toEntity(encodedPassword);
        log.info(request.toString());
        userRepository.save(user);
    }

    @Override
    public SignInResponse signIn(SignInRequest request) {
        Optional<User> byEmail = userRepository.findByEmail(request.email());
        // User user = byEmail.orElseThrow(() -> new IllegalArgumentException("회원 아님"));
        // if(!passwordEncoder.matches(request.password(), user.getPassword())){
        //     throw new IllegalArgumentException("회원 아님");
        // }
        // -> 더 간단하게
        if(byEmail.isEmpty() || !passwordEncoder.matches(request.password(), byEmail.get().getPassword()))
            throw new IllegalArgumentException("아이디 또는 비밀번호를 잘못 입력했습니다.");

        String token = jwtUtil.generateToken(request.email());
        return SignInResponse.from(token);
    }

}
