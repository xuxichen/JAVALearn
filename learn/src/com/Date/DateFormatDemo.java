package com.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatDemo {
    public static void main(String[] args) throws ParseException {
        fomatTime();
        stringToTime();
    }

    private static void stringToTime() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date date = dateFormat.parse("2021年01月04日 17时13分30秒");
        System.out.println(date);
    }

    private static void fomatTime() {
        DateFormat dateFormat = new  SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String time = dateFormat.format(new Date());
        System.out.println(time);
    }
}

