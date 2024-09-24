package com.GenericClass;

public class GenericInterfaceImp implements GenericInterface<String>{
    @Override
    public String method(String s) {
        return s;
    }
}
