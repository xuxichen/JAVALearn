package com.backLamda;

import java.util.Arrays;
import java.util.Comparator;

public class LamdaComparatorMain {
    public static Comparator<String > getComparator() {
        // 匿名内部类
//        return new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        };

        // lamda表达式
        return (o1, o2)-> o1.length() - o2.length();
    }

    public static void main(String[] args) {
        String[] arr = {"aa", "aHHJbc", "ddse", "d", "ghbnkjbhjvjk", "ccs"};

        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, getComparator());
        System.out.println("======================");
        System.out.println(Arrays.toString(arr));
    }
}
