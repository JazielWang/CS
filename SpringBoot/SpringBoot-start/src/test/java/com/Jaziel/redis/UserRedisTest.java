package com.Jaziel.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

/**
 * @author 王杰
 * @time 2020/11/4 20:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        // 字符串 string(两个都可以）
        //redisTemplate.opsForValue().set("rts", "wj");
        redisTemplate.boundValueOps("rts").set("lj");
        System.out.println(redisTemplate.opsForValue().get("rts"));

        // hash散列
        redisTemplate.boundHashOps("h_key").put("name", "heima");
        redisTemplate.boundHashOps("h_key").put("age", 13);
        // 获得所有域
        Set<Object> set = redisTemplate.boundHashOps("h_key").keys();
        System.out.println(" hash散列的所有域：" + set);
        // 获得所有值
        List<Object> list = redisTemplate.boundHashOps("h_key").values();
        System.out.println(" hash散列的所有域的值：" + list);

        // list 列表
        redisTemplate.boundListOps("l_key").leftPush("c");
        redisTemplate.boundListOps("l_key").leftPush("b");
        redisTemplate.boundListOps("l_key").leftPush("a");
        // 获得全部元素
        list = redisTemplate.boundListOps("l_key").range(0L, -1L);
        System.out.println(" list列表中的所有元素：" + list);

        // set 列表
        redisTemplate.boundSetOps("s_key").add("a", "b", "c");
        set = redisTemplate.boundSetOps("s_key").members();
        System.out.println(" set集合中的所有元素：" + set);

        // 有序列表
        redisTemplate.boundZSetOps("z_key").add("a", 30.0D);
        redisTemplate.boundZSetOps("z_key").add("b", 20.0D);
        redisTemplate.boundZSetOps("z_key").add("c", 10.0D);
        set = redisTemplate.boundZSetOps("z_key").range(0L, -1L);
        System.out.println(" zset有序集合中的所有元素：" + set);
    }
}
