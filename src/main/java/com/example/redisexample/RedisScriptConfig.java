package com.example.redisexample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

@Configuration
public class RedisScriptConfig {

	@Bean
	public RedisScript<Boolean> script() {
		ResourceScriptSource resourceScriptSource = new ResourceScriptSource(
			new ClassPathResource("META-INF/script/increment.lua"));
		return RedisScript.of(resourceScriptSource.getResource(), Boolean.class);

	}
}
