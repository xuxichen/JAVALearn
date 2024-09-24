package com.Annotation;

/**
 * 自定义注解
 *      格式：
 *          元注解
 *          public @interface 注解名 {}
 *      本质： 注解本质就是一个接口，该接口默认继承Annotation接口
 *          public interface MyAnnotation extend java.lang.annotation.Annotation {}
 *      属性： 接口中的抽象方法
 *          要求：
 *              1、属性的返回值类型
 *                  基本数据类型
 *                  String
 *                  枚举
 *                  注解
 *                  以上类型的数组
 *              2、定义了属性，使用时需要给属性赋值
 *                  1、如果定义属性时，使用default给属性默认初始化值，则使用时可以不进行属性的赋值
 *                  2、如果只有一个属性需要赋值，而且属性的名称为value，则属性明可以省略
 *      元注解： 用于描述注解的注解
 *          *@Target: 描述注解能攻作用到的位置
 *              ElementType:
 *              *TYPE, 作用在类上
 *              *FIELD, 作用在成员变量上
 *              *METHOD, 作用在方法上
 *
 *          *@Retention: 描述注解被保留的阶段
 *              @Retention(RetentionPolicy.RUNTIME):当前的被描述的注解，会保留到class字节码文件中，并被JVM读取到
 *          *Documented: 描述注解是否被抽取到api文档中
 *          *@Inherited: 描述注解是否被子类继承
 *
 *
 * 在程序中使用（解析）注解：获取注解中定义的属性值
 */
public @interface MyAnnotation {

    int show1();

    String show2();

    MyEnum show3();

    MyAnnota2 show4();

    String[] show5();



}
