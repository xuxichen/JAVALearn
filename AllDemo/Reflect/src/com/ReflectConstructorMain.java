package com;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectConstructorMain {
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

        // 获取public修饰成员变量
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        try {
            Constructor<Person> constructor = personClass.getConstructor(String.class, Integer.class, String.class);
            Constructor<Person> constructor1 = personClass.getConstructor();
            Person person = constructor.newInstance("佟丽娅", 29, "女");
            System.out.println(constructor1);
            System.out.println(constructor);
            System.out.println(person);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
