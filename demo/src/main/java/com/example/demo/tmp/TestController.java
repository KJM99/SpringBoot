package com.example.demo.tmp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

//@Controller
// 메소드가 늘어남에 따라 @ResponseBody 를 계속 치기 귀찮으니 @RestController 사용
// @ResponseBody 와 @RestController 가 합쳐진 것
@RestController
public class TestController {
    String text; // @Bean 으로 선언된 String test(){ return "test"; } 를 가져옴
    HashMap<String, Object> person;

    @Autowired
    Test test1;

    public TestController(String text, HashMap<String, Object> person, Test test){
        this.text = text;
        this.person = person;
        this.test1 = test;
    }

//    @ResponseBody // Return Body
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test(){
        return test1.toString();
    }

    // Return View
//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public Map<String, Object> test1(){
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "Kim");
//        map.put("age", 5);
//
//        return map;
//    }
}
