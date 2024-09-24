package com.ThreadAndLambda;

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

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程执行了");
    }
}
