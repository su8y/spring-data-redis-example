package com.example.redisexample;

import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class Example {

	@Autowired
	private RedisTemplate<String,String> redisTemplate;

	public void addLink(String userId, String url){
		redisTemplate.opsForList().leftPush(userId, url);
	}
}
