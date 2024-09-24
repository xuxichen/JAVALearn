package com.backLamda;

import com.LamdaLog.MessageBuilder;

public class BacklamdaMain {

    public static MyFunctionalInterface showLog2(int level, MessageBuilder messageBuilder) {
        if (level == 1) {
            return  ()->messageBuilder.builderMessage();
        } else {
            return ()->null;
        }

    }
    public static void main(String[] args) {
        String msg1 = "HELLO";
        String msg2 = "WORLD";
        String msg3 = "JAVA";

        System.out.println("lamda作为返回值"+showLog2(1, ()->{
            return msg1+msg2+msg3;
        }).builderMessage());
    }
}
