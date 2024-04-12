package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public String test11(){
		return "test";
	}

	@Bean
	public HashMap<String, Object> person() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "KimJaeMin");
		map.put("age", 26);

		return map;
	}

	@Bean
	public int age(){
		return 26;
	}

}
