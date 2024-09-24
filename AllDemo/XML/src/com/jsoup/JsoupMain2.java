package com.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupMain2 {
    public static void main(String[] args) {
        ClassLoader classLoader = JsoupMain2.class.getClassLoader();
        String path = classLoader.getResource("student.xml").getPath();
        try {
            Document document = Jsoup.parse(new File(path), "utf-8");
            // 选择器
            String text = document.select("name#ces").text();
            System.out.println(text);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
