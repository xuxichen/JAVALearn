package com.innerClass;

/*
 * 分类：
 * 1、成员内部类
 *      成员内部类的定义格式：
 *      修饰符 class 外部类名称 {
 *          修饰符 class 内部类名称 {
 *
 *          }
 *      }
 *
 * 2、局部内部类（包含匿名内部类）
 *
 */
public class InnerClass {
    public static void main(String[] args) {
        Body body = new Body();
        body.methodBody();

        System.out.println("=================");
        Body.heart heart = new Body().new heart();
        heart.beat();

        System.out.println("=================");

        Outer.Inner inner = new Outer().new Inner();

        inner.methodInner();

    }

}
