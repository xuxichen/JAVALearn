package com.Lambda0;

import java.util.Arrays;
import java.util.Comparator;

public class Lambda0 {
    public static void main(String[] args) {
        Person[] arr = {
                new Person("王祖贤",21),
                new Person("张敏",22),
                new Person("古力娜扎",19),
                new Person("佟丽娅",20),
                new Person("章泽天",18),
        };

//        // 对数组中Person对象实用化Arrays的sort方法通过年龄进行升序（前边-后边）排序
//        Arrays.sort(arr, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });

        // 使用Lambda表达式简化匿名内部类
        Arrays.sort(arr, (Person o1, Person o2)-> o1.getAge() - o2.getAge());

        for (Person person : arr) {
            System.out.println(person.getName() + "-----" + person.getAge());
        }

    }

}
