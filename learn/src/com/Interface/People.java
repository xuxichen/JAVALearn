package com.Interface;

public class People implements MyInterfaceDefault{
    @Override
    public void methodAbs() {
        System.out.println("实现了Default抽象方法 People");
    }

    @Override
    public void methodAbs2() {
        System.out.println("重写接口类的Default方法");
    }
}
