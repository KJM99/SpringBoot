package com.example.auth;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class AuthApplicationTests {
	@Value("${spring.datasource.username}")
	private String username;

	@Test
	void contextLoads() {
	}

	@Test
	void profilesUsernameTest(){
		Assertions.assertEquals("sa", username);
	}
}
