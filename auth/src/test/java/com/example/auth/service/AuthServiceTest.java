package com.example.auth.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.auth.domain.entity.User;
import com.example.auth.domain.entity.UserRepository;
import com.example.auth.domain.request.SignUpRequest;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class AuthServiceTest {

    @Autowired
    private AuthService authService;
    @Autowired
    private UserRepository userRepository;

    @Nested
    class 회원가입{
        @Test
        void 성공(){
            // given
            SignUpRequest request = new SignUpRequest("a@b.com",
                "1234",
                "sss",
                LocalDate.of(2000, 4, 7),
                "남"
            );

            // when
            authService.insertUser(request);

            // then
            Optional<User> byEmail = userRepository.findByEmail(request.email());
            assertTrue(byEmail.isPresent());
            assertNotEquals("1234", byEmail.get().getPassword());
        }

        @Test
        void 실패_이미_있는_이메일(){
            // given
            SignUpRequest request = new SignUpRequest("a@b.com",
                "1234",
                "sss",
                LocalDate.of(2000, 4, 7),
                "남"
            );
            userRepository.save(User.builder().email("a@b.com").build());

            // when & then
            assertThrows(IllegalArgumentException.class, () -> {
                authService.insertUser(request);
            });
        }
    }
}