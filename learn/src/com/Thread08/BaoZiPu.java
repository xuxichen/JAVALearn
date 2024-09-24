package com.Thread08;

/**
 * 生产者（包子铺）类：是一个线程类，可以继承Thread
 * 设置线程任务（run）生产包子
 * 对包子的状态进行判断
 * true： 有包子
 *      包子铺调用wait方法进入等待状态
 * false：没有包子
 *      包子铺生产包子
 *      增加一些趣味性：交替生产两种包子
 *          有两种状态（i%2 == 0）
 *      包子铺生产好了包子
 *      修改包子的状态为true
 *      唤醒吃货线程，让吃货线程吃包子
 *  ⚠️注意：
 *      包子铺线程和吃货线程互斥关系---->通信（互斥）
 *      必须使用同步技术保证两个线程只能有一个线程在执行
 *      锁对象必须唯一，可以使用包子对象作为锁对象
 *      包子铺和吃货的类就需要把包子对象作为参数传递进来
 *          1、需要在成员位置创建一个包子变量
 *          2、使用带参构造方法，为这个包子变量赋值
 */
public class BaoZiPu extends Thread{
    //1、需要在成员位置创建一个包子变量
    private BaoZi baoZi;

    public BaoZiPu(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    // 生产包子
    @Override
    public void run() {
        // 定义一个变量用于交替生产不同皮馅的包子
        int count = 0;
        while (true) {
            // 必须使用同步技术保证两个线程只能有一个线程在执行
            synchronized (baoZi) {
                // 对包子的状态进行判断
                if (baoZi.state == true) {
                    // 包子铺调用wait方法进入等待状态
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 被唤醒之后执行，包子铺生产包子
                if (count%2==0) {
                    baoZi.pi = "薄皮";
                    baoZi.xian = "三鲜馅";
                } else {
                    baoZi.pi = "冰皮";
                    baoZi.xian = "牛肉大葱";
                }
                count++;
                System.out.println("包子铺正在生产：" + baoZi.pi + baoZi.xian+"包子");
                // 生产包子需要三秒钟
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 包子铺生产好了包子
                // 修改包子的状态为true
                baoZi.state = true;
                // 唤醒吃货线程，让吃货线程吃包子
                baoZi.notify();
                System.out.println("包子铺已经生产好了" + baoZi.pi + baoZi.xian+"包子，吃货可以开吃了");
            }
        }
    }
}
