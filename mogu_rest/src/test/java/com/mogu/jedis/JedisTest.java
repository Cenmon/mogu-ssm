package com.mogu.jedis;

import java.io.IOException;
import java.util.HashSet;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class JedisTest {
//	@Test
	public void testJedisSingle() {
		// 192.168.43.125
		// 
		Jedis jedis = new Jedis("192.168.23.129",6379);
//		jedis.auth("243626");
//		jedis.set("key1", "1");
//		jedis.set("key2", "2");
//		jedis.set("key3", "3");
//		System.out.println(jedis.get("key1"));
//		System.out.println(jedis.get("key2"));
//		System.out.println(jedis.get("key3"));
		System.out.println(jedis.get("a"));
		jedis.close();
	}
	
	@Test
	public void testJedisPool() {
		JedisPool pool = new JedisPool("192.168.23.129",6379);
		Jedis jedis = pool.getResource();
//		jedis.set("Key", "1000");
//		System.out.println(jedis.get("Key"));
		System.out.println(jedis.hget("REST_INDEX_ITEM_CAT_SORT","itemCatList"));
		jedis.close();
		pool.close();
	}
	
	//@Test
	public void testJedisCluster() throws Exception {
		HashSet<HostAndPort> nodeSet = new HashSet<>();
		nodeSet.add(new HostAndPort("192.168.23.129", 7001));
		nodeSet.add(new HostAndPort("192.168.23.129", 7002));
		nodeSet.add(new HostAndPort("192.168.23.129", 7003));
		nodeSet.add(new HostAndPort("192.168.23.129", 7004));
		nodeSet.add(new HostAndPort("192.168.23.129", 7005));
		nodeSet.add(new HostAndPort("192.168.23.129", 7006));
		
		JedisCluster cluster = new JedisCluster(nodeSet);
		
		cluster.set("key1","1000");
		String string = cluster.get("key1");
		System.out.println(string);
		
		cluster.close();
	}
	
//	@Test
	public void TestJedisSpringSingle() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-jedis.xml");
		for (String string : applicationContext.getBeanDefinitionNames()) {
			System.out.println(string);
		}
		System.out.println(applicationContext.getBeanDefinitionCount());
		JedisPool jedisPool = (JedisPool)applicationContext.getBean("jedisPool");
		Jedis jedis = jedisPool.getResource();
		System.out.println(jedis.get("cenmo"));
		jedis.close();
		jedisPool.close();
	}
	
//	@Test
	public void TestJedisSpringCluster() throws IOException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-jedis.xml");
		JedisCluster jedisCluster = (JedisCluster)applicationContext.getBean("jedisCluster");
		System.out.println(jedisCluster.get("cenmo"));
		jedisCluster.close();
	}
}
