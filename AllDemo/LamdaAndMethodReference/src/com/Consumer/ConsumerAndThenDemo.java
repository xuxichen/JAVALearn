package com.Consumer;

import java.util.function.Consumer;

public class ConsumerAndThenDemo {
    public static void method(String[] arr, Consumer<String > consumer, Consumer<String> consumer2) {
        for (String message : arr) {
            consumer.andThen(consumer2).accept(message);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"古力娜扎,女", "佟丽娅,女", "郭品超,男"};
        method(arr,(message)->{
            String[] msgArr = message.split(",");
            System.out.println("姓名："+msgArr[0]);
        },(message)->{
            String[] msgArr = message.split(",");
            System.out.println("性别："+msgArr[1]);
        });

    }
}
