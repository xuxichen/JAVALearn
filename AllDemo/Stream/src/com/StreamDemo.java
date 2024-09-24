package com;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<String > arrayList = new ArrayList<>();

        arrayList.add("张三丰");
        arrayList.add("古力娜扎");
        arrayList.add("哈尼克孜");
        arrayList.add("张国荣");
        arrayList.add("向华强");
        arrayList.add("张丹");

        arrayList.stream()
                .filter(name-> name.startsWith("张"))
                .filter(neme->neme.length() == 3)
                .forEach(name-> System.out.println(name));

        System.out.println("==========================");

        Stream<String> stream1 = arrayList.stream()
                .filter(name-> name.startsWith("张"))
                .filter(neme->neme.length() == 3);

        Stream<String> stream2 = Stream.of("1", "2", "3", "4", "5", "6");

        // 使用map方法把字符串类型的整数转换（映射）为Integer类型的整数
        Stream<Integer> stream3 = stream2.map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        });
        System.out.println(stream3.count());
        System.out.println(stream1.count());

        System.out.println("==========================");
        Stream<String> stream4 = Stream.of("1", "2", "3", "4", "5", "6");
        Stream<String> stream5 = stream4.limit(4);
        stream5.forEach(s-> System.out.println(s));

        System.out.println("==========================");
        arrayList.stream().skip(3).forEach(name-> System.out.println(name));

        System.out.println("==========================");
        Stream<String> stream6 = Stream.of("乔峰", "段誉", "虚竹", "阿朱", "王语嫣", "西夏国公主");
        Stream<String> stream7 = Stream.concat(arrayList.stream(), stream6);
        stream7.forEach(name-> System.out.println(name));
    }
}
