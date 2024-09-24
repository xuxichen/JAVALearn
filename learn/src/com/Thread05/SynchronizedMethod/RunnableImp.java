package com.Thread05.SynchronizedMethod;

/**
 * 实现卖票案例出现了线程安全问题
 * 卖出了不存在的票和重复的票
 *
 * 解决线程安全问题： 同步方法
 * 格式：
 * public synchronized void method() {
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
            method();
            try {
                Thread.sleep(1300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void method() {
        if (ticket>0) {
            System.out.println(Thread.currentThread().getName() + "--->正在卖第"+ ticket + "张票");
            ticket--;
        }
    }

}
