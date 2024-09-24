package com.File.Recursion;

import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        System.out.println("请输入一个整数按回车键：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(Sum(n));

        System.out.println(Factorial(n));

    }

    private static int Factorial(int i) {
        if (i==1) {
            return 1;
        } else {
            System.out.println("阶乘的值 === " + i);
            return i * Factorial(--i) ;
        }
    }

    public static int Sum(int i) {
        if (i==1) {
            System.out.println("i ==== ：" + i);
            return 1;
        } else {
            System.out.println("i ==== ：" + i);
            return i + Sum(--i) ;
        }
    }
}
