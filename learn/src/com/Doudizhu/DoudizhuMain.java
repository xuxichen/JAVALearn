package com.Doudizhu;

import java.util.ArrayList;
import java.util.Collections;

public class DoudizhuMain {
    public static void main(String[] args) {
        String[] colors = {"♥️", "♠️", "♣️", "♦️"};
        String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};

        ArrayList<String> puker = new ArrayList<>();
        for (String color : colors) {
            for (String number : numbers) {
                puker.add(color+number);
            }
        }
        puker.add("大王");
        puker.add("小王");

        Collections.shuffle(puker);
        
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();

        for (int i = 0; i < puker.size(); i++) {
            String p = puker.get(i);
            if (i>=51) {
                dipai.add(p);
            }else if (i%3==0) {
                player1.add(p);
            }else if (i%3==1) {
                player2.add(p);
            }else if (i%3==2) {
                player3.add(p);
            }
        }

        System.out.println(puker.size());
        System.out.println(puker.toString());

        System.out.println(dipai.toString());
        System.out.println(player1.toString());
        System.out.println(player2.toString());
        System.out.println(player3.toString());

    }
}
