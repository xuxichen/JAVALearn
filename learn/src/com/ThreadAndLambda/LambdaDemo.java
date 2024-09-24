package com.ThreadAndLambda;

/**
 * 使用实现Runnable接口的方式实现多线程程序
 */
public class LambdaDemo {
    public static void main(String[] args) {
//        RunnableImp runnableImp = new RunnableImp();
//        Thread thread = new Thread(runnableImp);
//        thread.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程执行了");
            }
        }).start();
    }
}
