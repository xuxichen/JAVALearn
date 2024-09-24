package com.test;

import com.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JacksonTest {

    // java对象转为json对象
    @Test
    public void test1() {

        // 1、创建Person对象
        Person person = new Person();
        person.setName("张三");
        person.setAge(19);
        person.setSex("男");


        // 2、创建Jackson对象，ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        /**
         * 3、转换
         *  转换方法：
         *      writerValue(参数1, obj)
         *          参数1：
         *              File：将obj对象转化成json字符串，并保存到指定的文件中
         *              Writer：将obj对象转化成json字符串，并将json数据填充到字符输出流中
         *              OutputStream：将obj对象转化成json字符串，并将json数据填充到字节输出流中
         *      writerValueAsString(obj):将对象转为json字符串
         */
        try {
            String string = objectMapper.writeValueAsString(person);
            System.out.println(string);

            /**
             * 相对路径不行
             * 只能用绝对路径
             */
//            File file = new File("JQuery/src/a.txt");
//            FileWriter fileWriter = new FileWriter("JQuery/src/a.txt");
            File file = new File("/Users/xuxc19/Desktop/java/MultiModules2/JQuery/src/a.txt");
            objectMapper.writeValue(file, person);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2() {

        // 1、创建Person对象
        Person person = new Person();
        person.setName("张三");
        person.setAge(19);
        person.setSex("男");
        person.setBirthday(new Date());

        // 2、创建Jackson对象，ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        /**
         * 3、转换
         *  转换方法：
         *      writerValue(参数1, obj)
         *          参数1：
         *              File：将obj对象转化成json字符串，并保存到指定的文件中
         *              Writer：将obj对象转化成json字符串，并将json数据填充到字符输出流中
         *              OutputStream：将obj对象转化成json字符串，并将json数据填充到字节输出流中
         *      writerValueAsString(obj):将对象转为json字符串
         */
        try {
            String string = objectMapper.writeValueAsString(person);
            System.out.println(string);


        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test3() {

        // 1、创建Person对象
        Person person = new Person();
        person.setName("张三");
        person.setAge(19);
        person.setSex("男");
        person.setBirthday(new Date());

        // 1、创建Person对象
        Person person1 = new Person();
        person1.setName("李四");
        person1.setAge(19);
        person1.setSex("男");
        person1.setBirthday(new Date());
        // 1、创建Person对象
        Person person2 = new Person();
        person2.setName("王武");
        person2.setAge(19);
        person2.setSex("男");
        person2.setBirthday(new Date());

        ArrayList<Person> peoples = new ArrayList<>();
        peoples.add(person);
        peoples.add(person1);
        peoples.add(person2);
        // 2、创建Jackson对象，ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        /**
         * 3、转换
         *  转换方法：
         *      writerValue(参数1, obj)
         *          参数1：
         *              File：将obj对象转化成json字符串，并保存到指定的文件中
         *              Writer：将obj对象转化成json字符串，并将json数据填充到字符输出流中
         *              OutputStream：将obj对象转化成json字符串，并将json数据填充到字节输出流中
         *      writerValueAsString(obj):将对象转为json字符串
         */
        try {
            String string = objectMapper.writeValueAsString(peoples);
            System.out.println(string);


        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test4() {

        // 1、创建Person对象
        Person person = new Person();
        person.setName("张三");
        person.setAge(19);
        person.setSex("男");
        person.setBirthday(new Date());

        // 1、创建Person对象
        Person person1 = new Person();
        person1.setName("李四");
        person1.setAge(19);
        person1.setSex("男");
        person1.setBirthday(new Date());
        // 1、创建Person对象
        Person person2 = new Person();
        person2.setName("王武");
        person2.setAge(19);
        person2.setSex("男");
        person2.setBirthday(new Date());

        HashMap<String, Person> map = new HashMap<>();
        map.put("p", person);
        map.put("p1", person1);
        map.put("p2", person2);

        // 2、创建Jackson对象，ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String string = objectMapper.writeValueAsString(map);
            System.out.println(string);


        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test5() {

        String jsonStr = "{\"name\":\"张三\",\"age\":19,\"sex\":\"男\",\"birthday\":1619419906554}";
        // 2、创建Jackson对象，ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Person person = objectMapper.readValue(jsonStr, Person.class);
            System.out.println(person);


        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
