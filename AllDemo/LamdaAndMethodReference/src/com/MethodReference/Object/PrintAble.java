package com.MethodReference.Object;

/**
 * 定义一个打印的函数式接口
 */
@FunctionalInterface
public interface PrintAble {
    // 定义打印字符串的抽象方法
    void print(String s);
}
