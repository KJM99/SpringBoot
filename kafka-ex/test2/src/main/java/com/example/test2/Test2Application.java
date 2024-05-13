package com.example.test2;

import com.example.test2.dto.KafkaDto;
import com.example.test2.dto.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;

@SpringBootApplication
public class Test2Application {

	public static void main(String[] args) {
		SpringApplication.run(Test2Application.class, args);
	}

	@Bean
	public RecordMessageConverter converter() {
		return new JsonMessageConverter();
	}

	@KafkaListener(topics = "userTopic2")
	public void userTopicConsumer(KafkaDto<User> user){ // 보낸 객체랑 똑같은 객체 보내면 됨
		System.out.println(user);
	}
}
