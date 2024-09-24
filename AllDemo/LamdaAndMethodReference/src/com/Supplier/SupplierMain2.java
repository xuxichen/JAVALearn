package com.Supplier;

import java.util.function.Supplier;

public class SupplierMain2 {

    public static Integer getmax(Supplier<Integer> supplier) {
        return supplier.get();
    }
    public static void main(String[] args) {

        int[] arr = {100, -50, 0, 3, 22};
        int maxresult = getmax(()->{
            int max = arr[0];
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i+1]>max) {
                    max = arr[i+1];
                }
            }
            return max;
        });
        System.out.println(maxresult);

    }
}
