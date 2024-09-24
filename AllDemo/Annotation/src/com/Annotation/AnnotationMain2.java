package com.Annotation;

/**
 * 注解的演示
 * JDK 的预定义的一些注解
 *      *@Override          检测被该注解标注的方法是否继承自父类
 *      *@Deprecated        该注解标注的内容，表示已过时
 *      *@SuppressWarning   压制警告
 */

public class AnnotationMain2 {

    /**
     * 计算两数之和
     * @param a 整数
     * @param b 整数
     * @return 两数之和 整数
     */
    public int add(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) {

    }
}
