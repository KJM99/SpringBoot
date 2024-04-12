package com.example.demo;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@SpringBootApplication
public class
DemoApplication {

//	@Bean
//	public int testIndex(){
//		return 1;
//	} // IOC 컨테이너에 등록되는 것을 보기 위한 실습 코드

	public static void main(String[] args) {
		/*ConfigurableApplicationContext run = */
		SpringApplication.run(DemoApplication.class, args);
//		ConfigurableListableBeanFactory beanFactory = run.getBeanFactory();
//		Iterator<String> beanNamesIterator = beanFactory.getBeanNamesIterator();
//		while (beanNamesIterator.hasNext())
//			System.out.println(beanNamesIterator.next());
	}
}

//@Component
//class MyTest{
//
//} // IOC 컨테이너에 등록되는 것을 보기 위한 실습 코드
