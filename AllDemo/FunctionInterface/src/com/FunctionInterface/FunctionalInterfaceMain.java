package com.FunctionInterface;

public class FunctionalInterfaceMain {
    public static void show(MyFunctionInterface myInter) {
        myInter.method();
    }

    public static void main(String[] args) {
        //
        show(()->{
            System.out.println("Lamd");
        });

        show(new MyFunctionalInterfaceImp());

        show(new MyFunctionInterface() {
            @Override
            public void method() {
                System.out.println("匿名函数");

            }
        });
    }
}
