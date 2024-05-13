package com.example.test1.dto;

public record KafkaDto<T>(
    String status, T data
) {

}
