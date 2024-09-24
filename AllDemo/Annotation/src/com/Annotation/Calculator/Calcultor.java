package com.Annotation.Calculator;

public class Calcultor {

    // 加法
    @CheckAnnota
    public int add(Integer a, Integer b) {
        return a + b;
    }

    // 减法
    @CheckAnnota
    public int sub(Integer a, Integer b) {
        return a - b;
    }

    // 乘法
    @CheckAnnota
    public int mul(Integer a, Integer b) {
        return a * b;
    }

    // 除法
    @CheckAnnota
    public int div(Integer a, Integer b) {
        return a / b;
    }


    public void show() {
        System.out.println("永无bug。。。。");
    }
}
