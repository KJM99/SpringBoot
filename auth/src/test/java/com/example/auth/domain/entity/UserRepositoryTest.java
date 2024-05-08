package com.example.auth.domain.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByEmail() {
        User user = User.builder().email("t@t.com").build();
        userRepository.save(user);

        Optional<User> byEmail = userRepository.findByEmail("t@t.com");

        assertTrue(byEmail.isPresent());
    }
}