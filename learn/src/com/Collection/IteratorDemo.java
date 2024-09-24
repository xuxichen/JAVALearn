package com.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("姚明");
        collection.add("詹姆斯");
        collection.add("杜兰特");
        collection.add("科比");
        collection.add("乔丹");
        collection.add("库里");
        collection.add("韦德");

        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
