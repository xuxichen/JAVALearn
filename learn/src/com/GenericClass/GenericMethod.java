package com.GenericClass;

public class GenericMethod {

    public <E> E method(E param){
        return param;
    }
    public static  <E> E methodStatic(E param){
        return param;
    }
}
