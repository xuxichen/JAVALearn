package com.GenericClass;

import javax.swing.*;

public class GenericDemo {
    public static void main(String[] args) {
        GenericClass genericClass = new GenericClass();
        genericClass.setName("这是一个字符串");

        String name = (String) genericClass.getName();
        System.out.println(name);

        GenericClass<Integer> genericClass1 = new GenericClass<>();
        genericClass1.setName(967);

        System.out.println(genericClass1.getName());

        GenericMethod gm = new GenericMethod();
        Integer d = gm.method(56);

        String sdfa = gm.methodStatic("dedada");
        System.out.println(sdfa);
        System.out.println(d);
        String cdd = GenericMethod.methodStatic("eed");
        System.out.println(cdd);

        GenericInterfaceImp genericInterfaceImp = new GenericInterfaceImp();
        genericInterfaceImp.method("4567i8oiilkjhg");

        GenericInterfaceImp2<Integer> genericInterfaceImp2 = new GenericInterfaceImp2<>();
        genericInterfaceImp2.method(33243);
    }
}
