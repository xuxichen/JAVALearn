package com.backLamda;

public class BackLamdaMain2 {
    public static void startThread(Runnable runnable) {
        new Thread(runnable).start();
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        startThread(()-> System.out.println(Thread.currentThread().getName()));
    }
}
