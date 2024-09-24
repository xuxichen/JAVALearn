package com.GenericClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 范型的上限限定：? extends E  代表使用的范型只能是E类型的子类/本身
 * 范型的下限限定：? super E  代表使用的范型只能是E类型的父类/本身
 */
public class GenericTP2 {
    public static void main(String[] args) {
        Collection<Integer> arrayList = new ArrayList<>();
        Collection<String> arrayList1 = new ArrayList<>();
        Collection<Number> arrayList2 = new ArrayList<>();
        Collection<Object> arrayList3 = new ArrayList<>();

        getElement(arrayList);
//        getElement(arrayList1);
        getElement(arrayList2);
        getElement(arrayList3);

        getElement2(arrayList);
//        getElement2(arrayList1);
        getElement2(arrayList2);
//        getElement2(arrayList3);

    }

    private static void getElement2(Collection<? extends Number> arrayList) {
    }

    private static void getElement(Collection<? super Integer> arrayList) {
    }


}
