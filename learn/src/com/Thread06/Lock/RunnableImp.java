package com.Thread06.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现卖票案例出现了线程安全问题
 * 卖出了不存在的票和重复的票
 *
 * 解决线程安全问题： Lock 锁
 * 使用步骤：
 *      1、在成员位置创建一个ReentrantLock对象
 *      2、在可能会出现安全问题的代码前调用Lock接口中的方法lock获取锁
 *      3、在可能会出现安全问题的代码后调用Lock接口中的方法unlock释放锁
 *
 */

public class RunnableImp implements Runnable {
    // 定义一个多个线程共享的票源
    private int ticket = 100;

    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (ticket>0) {
                System.out.println(Thread.currentThread().getName() + "--->正在卖第"+ ticket + "张票");
                ticket--;
            }

            if (ticket<=0) {
                lock.unlock();
                break;
            }
            lock.unlock();
            try {
                Thread.sleep(1300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
