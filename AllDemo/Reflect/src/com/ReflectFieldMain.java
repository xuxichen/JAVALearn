package com;

import java.lang.reflect.Field;

public class ReflectFieldMain {
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
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        try {
            Field field = personClass.getField("sex");
            Person person = new Person();
            field.set(person, "男");

            Object o = field.get(person);
            System.out.println(o);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        try {
            Field name = personClass.getDeclaredField("name");

            // 忽略访问全县修饰符的安全检查
            name.setAccessible(true); // 暴力反射
            Person person = new Person();
            name.set(person, "古力娜扎");

            Object o = name.get(person);
            System.out.println(o);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
