package com.MethodReference.This;

/**
 * 通过this引用本类的成员变量
 */
public class Husband {

    // 定义一个买房子的方法
    public void buyHouse() {
        System.out.println("北京二环内买一套房子");
    }

    // 定义一个结婚的方法参数传递Richable 接口
    public void marry(Richable richable) {
        richable.buy();
    }

    // 定义一个非常高兴的方法
    public void soHappy() {
        // 调用结婚的方法，方法的参数Richable是一个函数式接口，传递Lamda表达式
        marry(()->{
            this.buyHouse();
        });
        marry(this::buyHouse);
    }

    public static void main(String[] args) {
        new Husband().soHappy();
    }
}
