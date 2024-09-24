package com.MethodReference.Constructor;

@FunctionalInterface
public interface PersonBuilder {

    // 定义一个方法，根据传递的姓名，创建person对象返回
    Person builder(String name);
}
