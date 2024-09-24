package com.MethodReference.Base;

public class PrintAbleMain {
    public static void printString(PrintAble printAble, String s) {
        printAble.print(s);
    }
    public static void main(String[] args) {
        printString((s)-> System.out.println(s), "WW");

        printString(System.out::println, "SSS");
    }
}
