package com.Thread06.Lock;

/**
 * 模拟卖票案例
 * 创建三个线程同时开启对共享的票进行出售
 */
public class ThreadMain {
    public static void main(String[] args) {
        RunnableImp runnableImp = new RunnableImp();
        Thread thread1 = new Thread(runnableImp);
        Thread thread2 = new Thread(runnableImp);
        Thread thread3 = new Thread(runnableImp);
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
