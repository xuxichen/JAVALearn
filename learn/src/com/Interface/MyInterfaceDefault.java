package com.Interface;

public interface MyInterfaceDefault {

    public abstract void methodAbs();

    public default void methodAbs2(){
        System.out.println("这是新添加的默认方法");
    }


}
