package com.jedis.test;

import com.jedis.utils.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * jedis 测试类
 */
public class JedisTest {

    /**
     * 快速入门
     */
    @Test
    public void test1() {
        // 1、 获取连接

        Jedis jedis = new Jedis("localhost", 6379);
        // 2、操作
        jedis.set("jedis", "测试");

        // 3、关闭连接
        jedis.close();

    }


    /**
     * string 的操作
     */
    @Test
    public void test2() {
        // 1、 获取连接

        Jedis jedis = new Jedis("localhost", 6379);
        // 2、存储
        jedis.set("jedis", "测试");

        // 获取
        String jedis1 = jedis.get("jedis");
        System.out.println(jedis1);

        jedis.setex("time", 4, "时间过去了");

        // 3、关闭连接
        jedis.close();

    }

    /**
     * hash 的操作
     */
    @Test
    public void test3() {
        // 1、 获取连接

        Jedis jedis = new Jedis("localhost", 6379);
        // 2、存储
        jedis.hset("names", "password", "124e");
        // 获取
        String password = jedis.hget("names", "password");
        System.out.println(password);

        Map<String, String> names = jedis.hgetAll("names");
        Set<String> strings = names.keySet();
        for (String key : strings) {
            System.out.println(key + ":" + names.get(key));
        }
        // 3、关闭连接
        jedis.close();
    }

    /**
     * list 的操作
     */
    @Test
    public void test4() {
        // 1、 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2、存储
        jedis.lpush("mylist", "java", "react");
        jedis.rpush("mylist", "ios", "android");
        // 获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        for (String s : mylist) {
            System.out.println(s);
        }

        List<String> lpop = jedis.lpop("mylist", 1);
        System.out.println(lpop);

        // 3、关闭连接
        jedis.close();
    }

    /**
     * set 的操作
     */
    @Test
    public void test5() {
        // 1、 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2、存储
        Long sadd = jedis.sadd("myset", "ios","ios","ios","java", "a", "c", "z");
        // 获取
        Set<String> myset = jedis.smembers("myset");
        for (String s : myset) {
            System.out.println(s);
        }
        // 3、关闭连接
        jedis.close();
    }

    /**
     * sortedSet 的操作
     */
    @Test
    public void test6() {
        // 1、 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2、存储
        jedis.zadd("mysortedset", 0, "ios");
        jedis.zadd("mysortedset", 0, "java");

        // 获取
        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);
        System.out.println(mysortedset);
        // 3、关闭连接
        jedis.close();
    }

    /**
     * 连接池
     */
    @Test
    public void test7() {
        // 创建配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxIdle(11);
        // 创建JedisPool 对象
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "localhost", 6379);
        // 获取连接池对象
        Jedis resource = jedisPool.getResource();
        // 使用
        resource.set("jedisPool", "连接池");

        // 关闭
        resource.close();
    }

    /**
     * 工具类连接池
     */
    @Test
    public void test8() {

        // 获取连接池对象
        Jedis resource = JedisPoolUtils.getJedis();
        // 使用
        resource.set("jedisPoolutils", "工具类获取Jedis");

        // 关闭
        resource.close();
    }
}
