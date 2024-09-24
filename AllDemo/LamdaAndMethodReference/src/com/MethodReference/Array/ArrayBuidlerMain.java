package com.MethodReference.Array;

import java.util.ArrayList;

public class ArrayBuidlerMain {

    public static int[] method(int length, ArrayBuidler arrayBuidler) {
        return arrayBuidler.builderArray(length);
    }
    public static void main(String[] args) {

        int[] array = method(10, (length)->{
            int[] arr= new int[length];
            return arr;
        });

        int[] array2 = method(10,(length)->new int[length]);

        int[] array3 = method(10, int[]::new);
        System.out.println(array.length);
        System.out.println(array2.length);
        System.out.println(array3.length);
    }
}
