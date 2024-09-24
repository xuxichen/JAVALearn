package com;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        ArrayList<String > array = new ArrayList<>();
        array.add("乔峰");
        array.add("段誉");
        array.add("虚竹");
        array.add("阿朱");
        array.add("王语嫣");
        array.add("慕容复");
        array.add("梦姑");
        array.add("段正淳");

        // 第一队伍只需要三个字的成员存储到一个新的集合
        ArrayList<String> arrayList1 = new ArrayList<>();
        array.forEach((name)->{
            if (name.length() == 3) {
                arrayList1.add(name);
            }
        });
        System.out.println("arrayList1 == " + arrayList1.toString());
        System.out.println("=======================");

        // 第一队伍过滤后只取前三哥成员存储到一个新的集合
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayList1.size(); i++) {
            if (i<3) {
                arrayList2.add(arrayList1.get(i));
            }
        }
        System.out.println("arrayList2 == " + arrayList2.toString());
        System.out.println("=======================");

        ArrayList<String> array2 = new ArrayList<>();
        array2.add("张三丰");
        array2.add("古力娜扎");
        array2.add("哈尼克孜");
        array2.add("张国荣");
        array2.add("向华强");
        array2.add("张丹");
        array2.add("张一山");
        array2.add("张天爱");

        // 第二只队伍只取姓张的成员存储到一个新的集合
        ArrayList<String> arrayList3 = new ArrayList<>();
        array2.forEach((name)->{
            if (name.startsWith("张")) {
                arrayList3.add(name);
            }
        });
        System.out.println("arrayList3 == " + arrayList3.toString());
        System.out.println("=======================");

        // 第二只队伍过滤后的去掉前两个成员存储到一个新的集合
        ArrayList<String> arrayList4 = new ArrayList<>();
        for (int i = 0; i < arrayList3.size(); i++) {
            if(i>=2) {
                arrayList4.add(arrayList3.get(i));
            }
        }
        System.out.println("arrayList4 == " + arrayList4.toString());
        System.out.println("=======================");

        // 把两个集合合并成一个集合存储到一个新的集合
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(arrayList2);
        arrayList.addAll(arrayList4);
        System.out.println("arrayList == " + arrayList.toString());
        System.out.println("=======================");

        ArrayList<Person> people = new ArrayList<>();
        arrayList.forEach(name->{
            people.add(new Person(name));
        });

        System.out.println("people == " + people.toString());
        System.out.println("=======================");
    }
}
