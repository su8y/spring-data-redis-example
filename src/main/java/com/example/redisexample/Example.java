package com.example.redisexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Example {

	@Autowired
	private RedisTemplate redisTemplate;

	public void plusData(String userId) {
		Integer o = (Integer)redisTemplate.opsForValue().get(userId);
		if (o == null) {
			redisTemplate.opsForValue().set(userId, 0);
		}
		// redisTemplate.opsForValue().set(userId, o + 1); // 원자적 연산 X
		redisTemplate.opsForValue().increment(userId); // 원자적 연산 O
	}

	public Integer getCount(String userId) {
		return (Integer)redisTemplate.opsForValue().get(userId);
	}
}
