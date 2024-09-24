package com.ThreadAndLambda;

/**
 *  使用Lambda表达式实现多线程程序
 *  lambda表达式的标准格式
 *      由三部分组成：
 *          a、一些参数
 *          b、一个箭头
 *          c、有段代码
 *      格式：
 *          (参数)->{一些重写方法的代码}
 *      解释说明格式：
 *          ():接口中抽象方法的参数列表，没有参数，就空着，由参数就写出参数，多个参数使用,分隔
 *          ->:传递的意思把参数传递给方法体
 *          {}:重写接口的抽象方法的方法体
 */
public class LambdaDemo0 {
    public static void main(String[] args) {
        new Thread(()-> System.out.println(Thread.currentThread().getName() + "线程执行了")).start();
    }
}
