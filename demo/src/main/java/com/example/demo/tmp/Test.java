package com.example.demo.tmp;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

// component 스프링 시작할 때, 자동으로 생성을 해서 IoC 컨테이너에 등록을 해줌
@Component
public class Test {
    private String name;
    private int age;

    public Test(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
