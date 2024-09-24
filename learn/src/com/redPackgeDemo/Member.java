package com.redPackgeDemo;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User {
    public Member() {
    }

    public Member(String name, Double money) {
        super(name, money);
    }

    public void receiver(ArrayList<Double> list) {
        int index = new Random().nextInt(list.size());
        System.out.println(list);
        Double delta = list.remove(index);

        Double money = super.getMoney();

        super.setMoney(money+delta);
    }
}
