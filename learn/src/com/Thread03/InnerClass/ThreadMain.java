package com.Thread03.InnerClass;


public class ThreadMain {
    public static void main(String[] args) {

        // 线程的父类是Thread ， 匿名类实现
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "---->" + i);
                }
            }
        }.start();

        // 线程的接口 Runnable
        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "---->" + i);
                }
            }
        }).start();

        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);
        }


    }
}

