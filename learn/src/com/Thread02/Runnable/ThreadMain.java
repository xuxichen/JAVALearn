package com.Thread02.Runnable;

public class ThreadMain {
    public static void main(String[] args) {
        RunnableImp01 runnableImp = new RunnableImp01();
        Thread thread = new Thread(runnableImp);
        thread.start();

        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);
        }
    }
}

