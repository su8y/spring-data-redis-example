package com.example.redisexample;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import redis.embedded.RedisServer;

@Profile("test")
@Configuration
public class EmbededRedisConfig {
	private RedisServer redisServer;

	public EmbededRedisConfig(@Value("${spring.data.redis.port}")int port) throws IOException {
		this.redisServer = new RedisServer(port);
	}

	@PostConstruct
	public void startRedisServer(){
		this.redisServer.start();
	}

	@PreDestroy
	public void stopRedisServer(){
		this.redisServer.stop();
	}
}
