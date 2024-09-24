package com.System;

import java.util.Arrays;

public class SystemDemo {
    public static void main(String[] args) {
//        currentTime();
        arraycopy();
    }

    private static void arraycopy() {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {7,8,9,10,11};
        System.out.println(Arrays.toString(arr2));

        System.arraycopy(arr1,0, arr2, 1, 3);
        System.out.println(Arrays.toString(arr2));

    }

    private static void currentTime() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 9999; i++) {
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("花了" + (end-start) + "毫秒");
    }
}
