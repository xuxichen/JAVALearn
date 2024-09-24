package com.Function;

import java.util.function.Function;

public class FunctionMain {

    public static int methos(String s, Function<String, Integer> function) {
        return function.apply(s);
    }
    public static void main(String[] args) {

        String s="10";
        Integer i = methos(s, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        });

        Integer i1 = methos(s, (v)->Integer.parseInt(v));
    }
}
