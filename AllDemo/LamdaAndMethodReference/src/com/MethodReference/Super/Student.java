package com.MethodReference.Super;

public class Student extends Human{

    @Override
    public void sayHello() {
        System.out.println("我是学生类，你好啊");
    }

    public void study() {
        System.out.println("学习ing");
    }

    public void superSayHello() {
        super.sayHello();
    }
}
