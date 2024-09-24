package com.IO.Properties;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
    public static void main(String[] args) {
        show01();

        load01();
    }

    private static void load01() {
        FileReader reader = null;
        FileInputStream stream = null;

        try {
            reader = new FileReader("./src/com/IO/Properties/prop.txt");
            stream = new FileInputStream("./src/com/IO/Properties/prop2.txt");

            Properties properties = new Properties();
            Properties properties1 = new Properties();

            properties.load(reader);
            properties1.load(stream);

            Set<String> keys = properties.stringPropertyNames();
            Set<String> keys1 = properties1.stringPropertyNames();

            for (String key:keys) {
                System.out.println(key + "======" + properties.getProperty(key));
            }
            for (String key:keys1) {
                System.out.println(key + "#######" + properties1.getProperty(key));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static void show01() {
        Properties properties = new Properties();
        properties.setProperty("aa", "HELLO");
        properties.setProperty("bb", "WORLD");
        properties.setProperty("cc", "JAVA");
        properties.setProperty("dd", "古力娜扎");
        properties.setProperty("佟丽娅", "29");

        // 这样添加不了键值对
//        properties.put("b", true);
        properties.setProperty("B", "true");

        Set<String> set = properties.stringPropertyNames();
        for (String s:set) {
            System.out.println(properties.getProperty(s));
        }

        FileWriter writer = null;
        FileOutputStream stream = null;
        try {
            writer = new FileWriter("./src/com/IO/Properties/prop.txt");
            stream = new FileOutputStream("./src/com/IO/Properties/prop2.txt");
            properties.store(writer, "save data");
            properties.store(stream, "stream save data");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
