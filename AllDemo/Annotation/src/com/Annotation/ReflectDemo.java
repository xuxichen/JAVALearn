package com.Annotation;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Pro(className = "com.Annotation.Person", methodName = "sayHello", paramName = {"lisa", "yellow"})
public class ReflectDemo {
    public static void main(String[] args) {

        //1、解析注解
        // 1.1、获取该类的字节码对象
        Class<ReflectDemo> reflectDemoClass = ReflectDemo.class;
        // 2、获取上面的注解对象
        // 2.1 这句代码实际就是在内存中生成一个该注解接口的子类实现对象
        Pro annotation = reflectDemoClass.getAnnotation(Pro.class);
        // 3、调用注解对象的抽象方法，获取返回值
        String className = annotation.className();
        String methodName = annotation.methodName();
        String[] param = annotation.paramName();
        try {
            // 加载该类进内存
            Class<?> aClass = Class.forName(className);
            // 创建对象
            Object o = aClass.getDeclaredConstructor().newInstance();
            Method method = aClass.getMethod(methodName, String.class, String.class);
            method.invoke(o, param);
        } catch ( ClassNotFoundException e) {
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
