package com.Thread08;

/**
 * 消费者（吃货）类：是一个线程类，可以继承Thread
 * 设置线程任务（run）： 吃包子
 * 对包子的状态进行判断
 * false： 没有包子
 *      吃货调用wait方法进入等待状态
 * true: 有包子
 *      吃货吃包子
 *      吃货吃完包子
 *      修改包子的状态为false没有
 *      吃货唤醒包子铺线程，生产包子
 */
public class ChiHuo extends Thread{

    //1、需要在成员位置创建一个包子变量
    private BaoZi baoZi;

    public ChiHuo(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    @Override
    public void run() {
        while (true) {
            // 必须使用同步技术保证两个线程只能有一个线程在执行
            synchronized (baoZi) {
                // 对包子的状态进行判断
                if (baoZi.state == false) {
                    // 唤醒包子铺生产包子
                    baoZi.notify();
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("吃货正在吃包子");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                baoZi.state = false;
                baoZi.notify();
                System.out.println("吃货吃完包子了");
            }
        }
    }
}
