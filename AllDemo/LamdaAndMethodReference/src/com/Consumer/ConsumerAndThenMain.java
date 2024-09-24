package com.Consumer;

import java.util.function.Consumer;

public class ConsumerAndThenMain {
    public static void method(String name, Consumer<String > consumer, Consumer<String> consumer2) {
        consumer.andThen(consumer2).accept(name);
    }

    public static void main(String[] args) {
        method("哇哈哈", new Consumer<String>() {
            @Override
            public void accept(String s) {
                String reverse = new StringBuffer(s).reverse().toString();
                System.out.println(reverse);
            }
        }, new Consumer<String>() {
            @Override
            public void accept(String s) {
                s = s + "王力宏";
                System.out.println(s);
            }
        });
        method("测试", (s)-> System.out.println(s), (s)->{
            s = s + "李准基";
            System.out.println(s);

        });
    }
}
