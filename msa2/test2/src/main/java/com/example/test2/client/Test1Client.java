package com.example.test2.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("TEST1") // application name 이 들어가면 됨
public interface Test1Client {
    // TEST1/api/test1
    @GetMapping("/api/test1")
    String test1();
}
