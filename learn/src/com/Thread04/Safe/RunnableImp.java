package com.Thread04.Safe;

/**
 * 实现卖票案例
 */

public class RunnableImp implements Runnable {
    // 定义一个多个线程共享的票源
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket>0) {
                System.out.println(Thread.currentThread().getName() + "--->正在卖第"+ ticket + "张票");
                ticket--;
            }
        }
    }
}
