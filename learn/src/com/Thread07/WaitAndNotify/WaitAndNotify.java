package com.Thread07.WaitAndNotify;

/**
 *
 */
public class WaitAndNotify {
    public static void main(String[] args) {
        // 创建锁对象
        Object object = new Object();

        // 创建顾客线程告诉老板包子中了和数量后进入等待
        new Thread() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println("顾客0告诉老板要的包子的种类和数量");
                    try {
                        object.wait(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("顾客0吃包子了");
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println("顾客1告诉老板要的包子的种类和数量");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("顾客1吃包子了");
                }
            }
        }.start();

        // 创建老板线程。准备5秒钟后唤醒顾客线程
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object) {
                    System.out.println("老板准备5秒后，告诉顾客，可以吃包子了");
//                    object.notify();
                    object.notifyAll();
                }
            }
        }.start();

    }
}
