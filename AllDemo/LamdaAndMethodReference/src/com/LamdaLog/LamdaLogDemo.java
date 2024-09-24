package com.LamdaLog;

public class LamdaLogDemo {
    public static void showLog(int level, String message) {
        if (level == 1) {
            System.out.println(message);
        }
    }

    public static void showLog2(int level, MessageBuilder messageBuilder) {
        if (level == 1) {
            System.out.println(messageBuilder.builderMessage());
        }
    }
    public static void main(String[] args) {
        String msg1 = "HELLO";
        String msg2 = "WORLD";
        String msg3 = "JAVA";

        showLog(1, msg1+msg2+msg3);

        showLog2(1, ()->{
            return msg1+msg2+msg3;
        });
    }
}
