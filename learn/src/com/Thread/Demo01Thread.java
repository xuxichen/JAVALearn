package com.Thread;

/**
 * 主线程
 */
public class Demo01Thread {
    public static void main(String[] args) {
        Person p1 = new Person("张三");
        Person p2 = new Person("李四");

        p1.run();
        p2.run();

    }
}
