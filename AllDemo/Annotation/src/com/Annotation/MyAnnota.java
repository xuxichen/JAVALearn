package com.Annotation;

public @interface MyAnnota {

    int age();

    String name();

    String sex() default "女";
}
