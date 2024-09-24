package com.Thread05.Synchronized;

/**
 * 实现卖票案例出现了线程安全问题
 * 卖出了不存在的票和重复的票
 *
 * 解决线程安全问题： 同步代码块
 * 格式：
 * synchronized(锁对象) {
 *     可能会出现的线程安全问题
 * }
 *
 */

public class RunnableImp implements Runnable {
    // 定义一个多个线程共享的票源
    private int ticket = 100;

    Object object = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                if (ticket>0) {
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "--->正在卖第"+ ticket + "张票");
                    ticket--;
                }
            }
        }
    }
}
