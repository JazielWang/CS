package com.Jaziel.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author 王杰
 * @date 2021/4/18 19:31
 */
public class JedisPoolTest {
    @Test
    public void test1(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        JedisPool jedisPool = new JedisPool("localhost", 6488);
        Jedis jedis = jedisPool.getResource();
        jedis.hset("hashmap", "username", "wj");
        String hget = jedis.hget("hashmap", "username");
        System.out.println(hget);

    }
}
