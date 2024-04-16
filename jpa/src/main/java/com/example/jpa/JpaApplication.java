package com.example.jpa;

import com.example.jpa.global.domain.entity.User;
import com.example.jpa.global.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class JpaApplication {
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);

//		Test test = new Test();
//		test.save();
	}
}

//@Component
//class Test{
//	@Autowired
//	private UserRepository userRepository;
//	public void save(){
//		userRepository.save(
//				new User(null,
//						"test",
//						"test",
//						"test"));
//	}
//}
