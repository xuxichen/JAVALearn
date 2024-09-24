package com.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateTest {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入出生年月日，格式为 'YYYY-MM-DD'");
        String birthday =scanner.next();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");
        Date date = simpleDateFormat.parse(birthday);
        long birthdayTime = date.getTime();
        long todayTime = new Date().getTime();
        long time = todayTime-birthdayTime;
        System.out.println(time/1000/60/60/24);
    }
}
