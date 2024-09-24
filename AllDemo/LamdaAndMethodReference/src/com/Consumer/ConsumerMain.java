package com.Consumer;

import java.util.function.Consumer;

public class ConsumerMain {
    public static void method(String name, Consumer<String > consumer) {
        consumer.accept(name);
    }

    public static void main(String[] args) {
        method("哇哈哈", new Consumer<String>() {
            @Override
            public void accept(String s) {
                String reverse = new StringBuffer(s).reverse().toString();
                System.out.println(reverse);
            }
        });
        method("测试", (s)-> System.out.println(s));
    }
}
