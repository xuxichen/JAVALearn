package com.noNameClass;

/**
 * 如果借口的实现类（或者父类的子类）只需要使用唯一的一次
 * 那么这种情况下就可以省略掉该类的定义，而改为使用【匿名内部类】。
 * 匿名内部类的定义格式
 * 接口名称 对象名 = new 接口名称() {
 *
 * }
 */
public class NoNameClass {
    public static void main(String[] args) {
//        MyInterface myInterface = new MyInterfaceImpl();
//        myInterface.method();

        MyInterface myInterface = new MyInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类实现类方法");
            }
        };
        myInterface.method();

    }
}
