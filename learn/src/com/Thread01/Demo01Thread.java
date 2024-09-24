package com.Thread01;

import com.Thread01.Person;

/**
 * 创建多线程的第一种方式： 创建Thread的子类
 */
public class Demo01Thread {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        Person p1 = new Person("张三", 19);
        Person p2 = new Person("李四", 22);

        p1.start();
        p2.start();
    }
}
