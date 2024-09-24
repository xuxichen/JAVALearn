package com.Collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();

        collection.add("HELLO");
        collection.add("WORLD");
        collection.add("CES");

//        collection.iterator();
        for (String s : collection) {
            System.out.println(s);
        }
//        collection.remove("HELLO");
//        System.out.println(collection);

//        boolean res = collection.contains("WORLD");
//        System.out.println(res);

//        Object[] arrayList = collection.toArray();
//        for (int i = 0; i < arrayList.length; i++) {
//            System.out.println(arrayList[i]);
//        }


//        System.out.println(collection.size());
//        System.out.println(collection);
//        collection.clear();
//        System.out.println(collection);

//        System.out.println(collection.isEmpty());
//        collection.clear();
//        System.out.println(collection.isEmpty());
    }
}
