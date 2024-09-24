package com.Predicate;

import java.util.function.Predicate;

public class PredicateMain {

    public static Boolean method(String string, Predicate<String> predicate) {
        return predicate.test(string);
    }

    public static Boolean method1(String string, Predicate<String> predicate1, Predicate<String> predicate2) {
        return predicate1.and(predicate2).test(string);
    }


    public static Boolean method2(String string, Predicate<String> predicate1, Predicate<String> predicate2) {
        return predicate1.or(predicate2).test(string);
    }

    public static Boolean method3(String string, Predicate<String> predicate1) {
        return predicate1.negate().test(string);
    }

    public static void main(String[] args) {

//        Boolean isLong =  method("哇哈哈净水", new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.length()>5;
//            }
//        });
        Boolean isLong = method("哇哈哈纯净水",(s)->s.length()>5);
        if (isLong) {
            System.out.println("字符串太长了");
        } else {
            System.out.println("字符串刚刚好");
        }

        Boolean isLong1 = method1("哇哈哈纯净水",(s)->s.length()>5, (s)->s.contains("o"));

        if (isLong1) {
            System.out.println("字符串大于5并且包涵o");
        } else {
            System.out.println("字符串不满足条件");
        }

        Boolean isLong2 = method2("哇哈哈纯净水",(s)->s.length()>5, (s)->s.contains("o"));
        if (isLong2) {
            System.out.println("字符串大于5或者包涵o");
        } else {
            System.out.println("字符串不满足条件");
        }

        Boolean isLong3 = method3("哇哈哈纯净水",(s)->s.length()>5);
        if (isLong3) {
            System.out.println("条件取反");
        } else {
            System.out.println("字符串不满足条件");
        }

    }
}
