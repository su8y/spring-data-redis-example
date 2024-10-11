package com.example.redisexample;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class ExampleTest {
	@Autowired
	private Example example;

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void test() {
		example.addLink("bae", "127.0.0.1");

		Object base = redisTemplate.opsForValue().get("bae");

		assertEquals((String)base, "127.0.0.1");
	}

}