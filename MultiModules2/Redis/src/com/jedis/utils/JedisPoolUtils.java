package com.jedis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Jedis 工具类
 *      加载配置文件， 配置连接池的参数
 *      提供获取连接的方法
 */
public class JedisPoolUtils {
    private static JedisPool jedisPool;

    static {
        // 创建Properties 对象
        Properties properties = new Properties();
        // 读取配置文件
        ClassLoader classLoader = JedisPoolUtils.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("jedis.properties");
        // 关联文件
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 创建 JedisPoolConfig 设置数据
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
        jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));

        // 创建JedisPool对象
        jedisPool= new JedisPool(jedisPoolConfig, properties.getProperty("host"), Integer.parseInt(properties.getProperty("port")));
    }
    /**
     * 获取连接方法
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

}
