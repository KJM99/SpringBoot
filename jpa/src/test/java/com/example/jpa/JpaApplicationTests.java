package com.example.jpa;

import com.example.jpa.global.domain.entity.User;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JpaApplicationTests extends InitData{
	@Autowired
	EntityManager em;

	@Test
	void contextLoads() {
	}

	@Test
	void N_PLUS_1(){
		em.flush();
		em.clear();
		List<User> all = userRepository.findAll(); // 10 + 1
		for(User user : all){
			System.out.println("start");
			System.out.println(user.getPlaylists().get(0).getTitle());
		}
	}
}



