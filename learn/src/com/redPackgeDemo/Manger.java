package com.redPackgeDemo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Random;

public class Manger extends User {
    public Manger() {
    }

    public Manger(String name, Double money) {
        super(name, money);
    }

    public ArrayList<Double> send(Double totalMoney, int count) {
        ArrayList<Double> arrayList = new ArrayList<>();

        Double leftMoney = super.getMoney();
        if (leftMoney<totalMoney) {
            System.out.println("余额不足");
            return arrayList;
        }
        super.setMoney((leftMoney-totalMoney));
        for (int i = 0; i < count; i++) {
            if (i==count-1) {
                arrayList.add(totalMoney);
            } else {
                double redMoney = Math.random()*totalMoney;
                BigDecimal bigDecimal = new BigDecimal(redMoney).setScale(2, RoundingMode.HALF_UP);
                redMoney = bigDecimal.doubleValue();
                arrayList.add(redMoney);
                System.out.println("redMoney == " + redMoney);
                totalMoney = new BigDecimal(totalMoney - redMoney).setScale(2, RoundingMode.HALF_UP).doubleValue();
            }
        }
        return arrayList;

    }
}
