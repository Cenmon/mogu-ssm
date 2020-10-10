package com.mogu.manager.testRedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class testRedis {

	@Test
	public void RedisTest() {
		JedisPool jedisPool = new JedisPool("192.168.117.129", 6379);
		Jedis jedis = jedisPool.getResource();
		jedis.set("mogu:01","cenmo");
		System.out.println(jedis.get("mogu:01"));
		jedis.close();
		jedisPool.close();
	}
}
