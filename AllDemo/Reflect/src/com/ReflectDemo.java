package com;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Set;

public class ReflectDemo {
    public static void main(String[] args) {
        // 可以创建任意类的对象，可以执行任意类的方法

        //1、加载配置文件
        //1、1创建Properties对象
        Properties properties = new Properties();
        //1、2 加载配置文件
//        try {
//            properties.load(new FileReader("Reflect/src/pro.properties"));
//            Set<String> strings = properties.stringPropertyNames();
//            for (String string : strings) {
//                System.out.println(string + "======" + properties.getProperty(string));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        ClassLoader classLoader = ReflectDemo.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("pro.properties");
        try {
            properties.load(resourceAsStream);
//            Set<String> strings = properties.stringPropertyNames();
//            for (String string : strings) {
//                System.out.println(string + "======" + properties.getProperty(string));
//            }
            String className = properties.getProperty("className");
            String methodName = properties.getProperty("methodName");
            String paramName = properties.getProperty("paramName");

            String[] param = paramName.split(",");
            // 加载该类进内存
            Class<?> aClass = Class.forName(className);
            // 创建对象
            Object o = aClass.getDeclaredConstructor().newInstance();
            Method method = aClass.getMethod(methodName, String.class, String.class);
            method.invoke(o, param);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
