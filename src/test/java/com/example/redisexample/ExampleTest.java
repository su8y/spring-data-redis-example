package com.example.redisexample;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.annotation.Repeatable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class ExampleTest {
	@Autowired
	private Example example;

	@Autowired
	private RedisTemplate<?, ?> redisTemplate;


	private final static int THREAD_MAX = 100;

	@RepeatedTest(value = 10)
	public void concurrencyTest() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(THREAD_MAX);

		ExecutorService executorService = Executors.newFixedThreadPool(THREAD_MAX);
		for (int i = 0; i < THREAD_MAX; i++) {
			executorService.submit(()->{
				try{
					example.plusData("bae");
				}finally {
					latch.countDown();;
				}
			});
		}

		latch.await();

		int count = example.getCount("bae");
		assertEquals(THREAD_MAX, count);
	}
	@RepeatedTest(value = 1)
	public void concurrencyTestWithLua() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(THREAD_MAX);

		ExecutorService executorService = Executors.newFixedThreadPool(THREAD_MAX);
		for (int i = 0; i < THREAD_MAX; i++) {
			executorService.submit(()->{
				try{
					example.plusDataWithScript("bae");
				}finally {
					latch.countDown();;
				}
			});
		}

		latch.await();

		int count = example.getCount("bae");
		assertEquals(THREAD_MAX, count);
	}

}