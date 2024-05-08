package com.example.test1;

import com.example.test1.dto.Test1Request;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Test1ApplicationTests {

	@Test
	void contextLoads() {
		new Test1Request("11", 1);
	}

}
