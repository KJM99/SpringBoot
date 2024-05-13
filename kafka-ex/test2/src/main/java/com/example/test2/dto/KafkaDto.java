package com.example.test2.dto;

public record KafkaDto<T>(
    String status, T data
) {

}
