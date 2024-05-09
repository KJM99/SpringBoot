package com.example.auth.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.auth.domain.entity.User;
import com.example.auth.domain.entity.UserRepository;
import com.example.auth.domain.request.SignInRequest;
import com.example.auth.domain.request.SignUpRequest;
import com.example.auth.domain.response.SignInResponse;
import com.example.auth.exception.ExistedUserException;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@Transactional
class AuthServiceTest {

    @Autowired
    private AuthService authService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Nested
    class 로그인 {
        @Test
        void 성공() {
            // given
            User init = User.builder().email("t@t.com")
                .password(passwordEncoder.encode("1234"))
                .nickname("tt")
                .gender("남")
                .birthDay(LocalDate.of(1990, 1, 1))
                .build();
            userRepository.save(init);
            SignInRequest request = new SignInRequest("t@t.com", "1234");

            // when
            SignInResponse res = authService.signIn(request);

            // then
            assertNotNull(res.token());
            System.out.println(res.token());
            assertEquals(3, res.token().split("\\.").length);
            assertEquals("Bearer", res.tokenType());
        }

        @Test
        void 실패_회원_없음() {
            // given
            User init = User.builder().email("t@t.com")
                .password(passwordEncoder.encode("1234"))
                .nickname("tt")
                .gender("남")
                .birthDay(LocalDate.of(1990, 1, 1))
                .build();
            userRepository.save(init);
            SignInRequest request = new SignInRequest("t@a.com", "1234");

            // when & then
            assertThrows(IllegalArgumentException.class, () -> authService.signIn(request));
        }

        @Test
        void 실패_비밀번호_틀림() {
            // given
            User init = User.builder().email("t@t.com")
                .password(passwordEncoder.encode("1234"))
                .nickname("tt")
                .gender("남")
                .birthDay(LocalDate.of(1990, 1, 1))
                .build();
            userRepository.save(init);
            SignInRequest request = new SignInRequest("t@t.com", "12345");

            // when & then
            assertThrows(IllegalArgumentException.class, () -> authService.signIn(request));
        }
    }

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
            assertThrows(ExistedUserException.class, () -> {
                authService.insertUser(request);
            });
        }
    }
}