package com.redPackgeDemo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Manger manger = new Manger("王方", (double) 500);
        Member one = new Member("A", (double) 0);
        Member two = new Member("B", (double) 0);
        Member three = new Member("C", (double) 0);

        manger.show();
        one.show();
        two.show();
        three.show();
        System.out.println("++++++++++++++++++");

        ArrayList<Double> arrayList = manger.send((double) 41, 3);
        one.receiver(arrayList);
        two.receiver(arrayList);
        three.receiver(arrayList);
        manger.show();
        one.show();
        two.show();
        three.show();
    }


}
