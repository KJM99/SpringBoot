package com.example.test1.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class Test1Request {
    @NotNull(message = "name is not null")
    @NotEmpty(message = "name is not empty")
    @Size(min = 3, max = 5)
    @Getter
    private final String name;
    private final int age;
}
