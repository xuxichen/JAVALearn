package com.Annotation;

import java.lang.annotation.Annotation;

/**
 * 注解的演示
 * JDK 的预定义的一些注解
 *      *@Override          检测被该注解标注的方法是否继承自父类
 *      *@Deprecated        该注解标注的内容，表示已过时
 *      *@SuppressWarning   压制警告
 */
@SuppressWarnings("all")
public class AnnotationMain {

    /**
     * 计算两数之和
     * @param a 整数
     * @param b 整数
     * @return 两数之和 整数
     */
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show() {
        System.out.println("Deprecated");
    }

    @MyAnnotation(show1 = 12, show2 = "韩东君", show3 = MyEnum.P1, show4 = @MyAnnota2("韩东君"), show5 = {"国画"} )
    public void demo() {
        show();
    }



    public static void main(String[] args) {
        // show();
    }
}
