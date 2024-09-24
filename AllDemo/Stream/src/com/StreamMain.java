package com;

import java.util.*;
import java.util.stream.Stream;

public class StreamMain {
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


        // 把集合转换成stream流
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();

        Map<String, String> map = new HashMap<>();
        // 获取键，存储到一个set集合中
        Set<String> keySet = map.keySet();
        Stream<String> stream3 = keySet.stream();


        // 获取值， 存储到一个Collection集合中
        Collection<String> collection = map.values();
        Stream<String> stream4 = collection.stream();

        // 获取键值对(键与值的映射关系 entrySet)
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String, String>> stream5 = entries.stream();

        Stream<Integer> stream6 = Stream.of(1, 2, 3, 4, 5, 6);

        Integer[] integers = {1, 2, 3, 4, 5};
        Stream<Integer> stream7 = Stream.of(integers);
    }
}
