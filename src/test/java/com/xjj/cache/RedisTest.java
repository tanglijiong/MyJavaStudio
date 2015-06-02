package com.xjj.cache;


import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.xjj.BaseJunit4Test;
import com.xjj.spring.data.XjjStringRedisOps;

@ContextConfiguration ({"classpath:spring/applicationContext-redis.xml"}) //加载配置文件
public class RedisTest extends BaseJunit4Test {
	@Autowired
	XjjStringRedisOps redisOps;
	
	@Test
	public void deleteTestKeys(){
		redisOps.DEL("xjj.v1");
		redisOps.DEL("xjj.v2");
		redisOps.DEL("xjj.h1");
		redisOps.DEL("xjj.11");
		redisOps.DEL("xjj.z1");
		HashSet<String> keySet = (HashSet<String>) redisOps.keys("xjj*");
		System.out.println(keySet);
		Assert.assertEquals("keys删除不成功！", new HashSet<String>(), keySet);
	}

	//String类型测试
	@Test
	public void setStringValue(){
		String key = "xjj.v1";
		String value = "Hello World2!";
		
		redisOps.SET(key, value);
		System.out.println("value of xjj: " + redisOps.GET(key));
		Assert.assertEquals(value, redisOps.GET(key));
	}
	
	@Test
	public void setStringValueWithTimeout(){
		String key = "xjj.v2";
		String value = "Hello World, xjj1!";
		long timeout = 100;
		
		redisOps.SET(key, value, timeout);
		System.out.println("ttl of xjj1: " + redisOps.TTL(key));
		Assert.assertEquals(timeout, redisOps.TTL(key));
	}
	
	//Hash类型测试
	
	@Test
	public void setHashValue(){
		String key = "xjj.h1";
		String field1 = "f1";
		String value1 = "123";
		
		redisOps.HSET(key, field1, value1);
		System.out.println(redisOps.HGET(key, field1));
		
		String field2 = "f2";
		String value2 = String.valueOf(888);
		redisOps.HSET(key, field2, value2);
		System.out.println(redisOps.HGET(key, field2));
		
		System.out.println(redisOps.HGETALL(key));
	}
	
	@Test
	public void delHashKeys(){
		redisOps.HDEL("xjj.h1", "f1", "f2"); //删除xjj.h1中的f1和f2
	}
	
	//List类型测试
	@Test
	public void ListOps(){
		String key = "xjj.l1";
		String value1 = "Java";
		
		redisOps.LPUSH(key, value1);
		
		String value2 = "php";
		redisOps.RPUSH(key, value2);
		
		System.out.println(redisOps.RPOP(key));
		System.out.println(redisOps.LPOP(key));
	}
	
	//Set类型测试
	@Test
	public void SetOps(){
		String key = "xjj.s1";
		String member1 = "Java";
		String member2 = "Python";
		String member3 = "PHP";
		
		redisOps.SADD(key, member1);
		redisOps.SADD(key, member2);
		redisOps.SADD(key, member3);
		
		System.out.println(redisOps.SMEMEBERS(key));
	}
	
	//SortedSet类型测试
	@Test
	public void ZSetOps(){
		String key = "xjj.z1";
		String member1 = "Java";
		String member2 = "Python";
		String member3 = "PHP";
		double score1 = 1.2;
		double score2 = 100.5;
		double score3 = 188;
		
		redisOps.ZADD(key, score1, member1);
		redisOps.ZADD(key, score2, member2);
		redisOps.ZADD(key, score3, member3);
		
		System.out.println(redisOps.ZRANGE(key, 1, 150));
	}
	
}
