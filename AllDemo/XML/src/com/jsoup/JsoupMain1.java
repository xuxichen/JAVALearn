package com.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupMain1 {
    public static void main(String[] args) {
        ClassLoader classLoader = JsoupMain1.class.getClassLoader();
        String path = classLoader.getResource("student.xml").getPath();
        try {
            Document document = Jsoup.parse(new File(path), "utf-8");
            Elements elements = document.getElementsByTag("name");
            for (Element element : elements) {

                System.out.println(element.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
