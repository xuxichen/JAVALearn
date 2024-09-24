package com.FunctionInterface;

/**
 * 函数式接口，有且只有一个抽象方法的接口，称之为函数式接口
 * 当然接口中可以包涵其他的方法（默认方法，静态方法，私有方法）
 */
// 注解
@FunctionalInterface
public interface MyFunctionInterface {
    // 定义一个抽象方法
    public abstract void method();

//    void method2();
}
