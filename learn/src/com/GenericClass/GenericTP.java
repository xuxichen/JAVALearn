package com.GenericClass;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 范型的通配符：
 * ?:代表任意的数据类型
 * 使用方式：
 * 不能创建对象使用，只能做为方法的参数使用
 *
 */
public class GenericTP {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(123);
        arrayList.add(4523);

        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("dsda");
        arrayList1.add("$$SEW");

        printArray(arrayList);
        printArray(arrayList1);
    }

    private static void printArray(ArrayList<?> arrayList) {
        Iterator<?> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
