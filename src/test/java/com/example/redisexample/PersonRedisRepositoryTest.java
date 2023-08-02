package com.example.redisexample;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRedisRepositoryTest {
    @Autowired
    private PersonRedisRepository repo;

    @Test
    void test() {
        Person person = new Person("Hello", 20);

        // 저장
        repo.save(person);
        System.out.println(person.getId());
        Assertions.assertThat(repo.findById(person.getId()).get().getAge()).isEqualTo(20);

        // `keyspace:id` 값을 가져옴
//        repo.findById(person.getId());
//
//        // Person Entity 의 @RedisHash 에 정의되어 있는 keyspace (people) 에 속한 키의 갯수를 구함
//
//        // 삭제
//        repo.delete(person);
    }

}