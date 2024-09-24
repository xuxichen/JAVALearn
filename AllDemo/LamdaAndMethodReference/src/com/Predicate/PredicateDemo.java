package com.Predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateDemo {

    public static ArrayList<String> method(String[] arr, Predicate<String> predicate1, Predicate<String> predicate2) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : arr) {
            String[] pepole = s.split(",");
            if (predicate1.test(pepole[0]) && predicate2.test(pepole[1])) {
                arrayList.add("姓名："+pepole[0]+"，性别："+pepole[1]);
            }
        }
        return arrayList;
    }

    public static ArrayList<String> method2(String[] arr, Predicate<String> predicate1, Predicate<String> predicate2) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : arr) {
            if (predicate1.and(predicate2).test(s)) {
                arrayList.add(s);
            }
        }
        return arrayList;
    }


    public static void main(String[] args) {

        String[] arr = {"古力娜扎,女", "佟丽娅,女", "郭品超,男", "哈尼克孜,女"};

        ArrayList<String> arrayList = method(arr, (s)->s.length()==4,(s)->s.equals("女") || s=="女");
        for (String s : arrayList) {
            System.out.println(s);
        }

        ArrayList<String> arrayList2 = method2(arr, (s)-> s.split(",")[0].length() == 4,(s)->s.contains("女"));
        for (String s : arrayList2) {
            System.out.println(s);
        }
    }
}
