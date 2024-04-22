package com.example.auth.service;

import com.example.auth.dto.request.SignupRequest;
import com.example.auth.global.domain.entity.User;
import com.example.auth.global.domain.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ActiveProfiles("test")
class AuthServiceImplTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthServiceImpl authService;

    @Test
    void login() {
        User user = new User(null, "1", "1", "1", null);
        userRepository.save(user);

    }

    @Test
    void signUp() {
        SignupRequest signupRequest = new
                SignupRequest("test", "test", "test");
        authService.signUp(signupRequest);

        List<User> byUsername = userRepository.findByUsername("test");
        assertEquals(1,byUsername.size());
        assertNotEquals(
                signupRequest.password(),
                byUsername.get(0).getPassword()
        );
        System.out.println(signupRequest.password()+"  "+
                byUsername.get(0).getPassword());

    }
    @Autowired
    PasswordEncoder passwordEncoder;
    @Test
    void matchPassword(){
        assertTrue(
                passwordEncoder.
                        matches("test"
                                , "$2a$10$ZdEmy8n.c4cJpPMnKhyGzu0xgSAdCIOEkhnQ/IeYWY9PTWSqfkG.a"));
    }
}