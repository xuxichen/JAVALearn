package com.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.seimicrawler.xpath.JXDocument;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsoupXpathMain1 {
    public static void main(String[] args) {
        ClassLoader classLoader = JsoupXpathMain1.class.getClassLoader();
        String path = classLoader.getResource("student.xml").getPath();
        try {
            Document document = Jsoup.parse(new File(path), "utf-8");
            // 根据document 创建xpath对象
//            JXDocument jxDocument = JXDocument.create(document);

            JXDocument jxDocument = new JXDocument(document.getAllElements());
            List<Object> sel = jxDocument.sel("//student");
            for (Object o : sel) {
                System.out.println(o);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
