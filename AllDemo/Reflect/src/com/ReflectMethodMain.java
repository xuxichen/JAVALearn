package com;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMethodMain {
    /**
     * Class对象功能
     * 获取功能
     *  1、获取成员变量们
     *      Field[] getField() 获取所有public修饰的成员变量
     *      Field getField(String name) 获取指定的public修饰的成员变量
     *
     *      Field[] getDeclaredFields() 获取所有成员变量,不考虑修饰符
     *      Field getDeclaredField(String name)
     *
     *  2、获取构造方法们
     *      Constructor<?>[] getConstructors()
     *      Constructor<T> getConstructor(类<?> ... parameterTypes)
     *
     *      Constructor<T> getDeclaredConstructor(类<?>... paramerterTypes)
     *      Constructor<?> getDeclaredConstructors()
     *
     *  3、获取成员方法们
     *      Method[] getMethods()
     *      Method getMethod(String name, 类<?>... parameterTypes)
     *
     *      Method[] getDeclaredMethods()
     *      Method getDeclaredMethod(String name, 类<?>... parameterTypes)
     *
     *  4、获取类名
     *      String getName
     *
     */

    public static void main(String[] args) {
        //1、获取Person的Class对象
        Class<Person> personClass = Person.class;

        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        try {
            Method sayHello = personClass.getMethod("sayHello", String.class, String.class);

            Person person = new Person("郭珍霓", 31, "女");
            sayHello.invoke(person, "李承乾", "小枫");

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 获取类名
        String name = personClass.getName();
        System.out.println(name);
    }
}
