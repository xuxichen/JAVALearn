package com.Supplier;

import java.util.function.Supplier;

public class SupplierMain {

    public static String getString(Supplier<String > supplier) {
        return supplier.get();
    }
    public static void main(String[] args) {
//        String s = getString(new Supplier<String>() {
//            @Override
//            public String get() {
//                return "胡歌";
//            }
//        });

        String s = getString(()->"胡歌");
        System.out.println(s);

    }
}
