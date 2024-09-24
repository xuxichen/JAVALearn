package com.Lambda1;

import java.util.Arrays;

public class Lambda {
    public static void main(String[] args) {
        int result = invokeCalc(12, 34, (a, b)->a + b);
        System.out.println(result);
    }

    public static int invokeCalc(int a, int b, Calculator c){
        return c.calc(a, b);
    }
}
