package com.factory.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

/**
 * 创建一个Bean对象的工厂
 *
 * 用BeanFactory工厂来创建我们所需要的service和dao
 * 第一点、需要一个配置文件来配置service和dao
 *      通过配置的内容，唯一标识=全限定类名
 * 第二点、通过读取配置文件中配置的内容，反射创建对象
 *
 * 配置文件可以用xml和properties
 */
public class BeanFactory {

    /**
     * 定义一个Properties静态变量
     */
    private static Properties properties;

    //定义一个map存放我们要创建的对象。我们可以称之为容器
    private static HashMap<String, Object> beans;
    static {
        // 创建Properties
        properties = new Properties();
        // 获取properties 文件的流对象
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");

        try {
            properties.load(in);
            // 实例化容器
            beans = new HashMap<String, Object>();
            // 取出配置文件中的key
            Enumeration<Object> keys = properties.keys();
            while (keys.hasMoreElements()) {
                // 循环取出key
                String key = keys.nextElement().toString();
                // 根据key获取value
                String beanPath = properties.getProperty(key);
                // 反射创建对象
                Object bean = Class.forName(beanPath).newInstance();
                // 把key和value放入map容器
                beans.put(key, bean);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }
//
//    /**
//     * 根据传入的名字获取bean对象
//     * @param beanName
//     * @return
//     */
//    public static Object getBean(String beanName) {
//        Object bean = null;
//        String beanPath = properties.getProperty(beanName);
//        System.out.println(beanPath);
//        try {
//            bean = Class.forName(beanName).newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }
}
