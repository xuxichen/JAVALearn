package com.Thread07.WaitAndNotify;

/**
 * 等待唤醒案例：线程之间的通信
 *      创建一个顾客线程（消费者）：告知老板要的包子的种类和数量，调用wait方法，放弃cpu的执行，进入到WAITING状态（无限等待）
 *      创建一个老板线程（生产者）：花了5秒钟做了包子，包子做好后。调用notify方法，唤醒顾客吃包子
 * 注意：
 *      顾客和老板线程必须使用同步代码块包裹起来。保证等待和唤醒只能有一个在执行
 *      同步使用的锁对象必须唯一
 *      只有锁对象才能调用wait和notify方法
 */
public class ThreadMain07 {
    public static void main(String[] args) {
        // 创建锁对象
        Object object = new Object();

        // 创建顾客线程告诉老板包子中了和数量后进入等待
        new Thread() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println("告诉老板要的包子的种类和数量");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("顾客吃包子了");
                }
            }
        }.start();

        // 创建老板线程。准备5秒钟后唤醒顾客线程
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object) {
                    System.out.println("老板准备5秒后，告诉顾客，可以吃包子了");
                    object.notify();
                }
            }
        }.start();

    }
}
