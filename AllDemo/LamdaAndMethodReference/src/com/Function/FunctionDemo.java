package com.Function;

import java.util.function.Function;

public class FunctionDemo {

    public static int methos(String s, Function<String, Integer> function) {
        return function.apply(s);
    }

    public static int methos2(String s, Function<String, Integer> function ,Function<Integer, Integer> function2) {
        return function.andThen(function2).apply(s);
    }

    public static int methos3(String s, Function<String, String> function ,Function<String, Integer> function2, Function<Integer, Integer>function3) {
        return function.andThen(function2).andThen(function3).apply(s);
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


        Integer integer = methos2(s, (v)->Integer.parseInt(v)+10,(v)->v*10);

        System.out.println(integer);


        String s1 = "沈冰,25";
        Integer integer1 =  methos3(s1, (v)->v.split(",")[1], (v)->Integer.parseInt(v),(v)->v+200 );
        System.out.println(integer1);
    }
}
