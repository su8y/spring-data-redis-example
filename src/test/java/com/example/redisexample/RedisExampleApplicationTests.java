package com.example.redisexample;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Set;

@SpringBootTest
class PersonRedisTemplateTest {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void testStrings() {
        // given
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String key = "stringKey";
        // when
        valueOperations.set(key, "hello");

        // then
        String value = valueOperations.get(key);
        Assertions.assertThat(value).isEqualTo("hello");

        // given
        SetOperations<String, String> stringStringSetOperations = redisTemplate.opsForSet();
        stringStringSetOperations.add("setKey", "hello");

        // when
        Set<String> setKey = stringStringSetOperations.members("setKey");

        // then
        Assertions.assertThat(setKey.size()).isEqualTo(1);
        Assertions.assertThat(setKey.contains("hello")).isTrue();
    }


}
