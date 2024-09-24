package com.Thread02.Runnable;

public class RunnableImp01 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("hello world");
        }
    }
}
