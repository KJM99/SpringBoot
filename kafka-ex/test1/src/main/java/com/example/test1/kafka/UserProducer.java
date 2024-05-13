package com.example.test1.kafka;

import com.example.test1.dto.KafkaDto;
import com.example.test1.dto.User;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    private final KafkaTemplate<String, KafkaDto<User>> kafkaTemplate;

    @Bean
    public NewTopic userTopic() {
        return new NewTopic("userTopic2", 1, (short) 1);
    }

    public void send(User user, String status){
        kafkaTemplate.send("userTopic2", new KafkaDto<>(status, user));
    }

    public UserProducer(KafkaTemplate<String, KafkaDto<User>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

}
