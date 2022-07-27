package org.example.lesson5;

import java.util.*;

public class Lesson5 {
    public static void main(String[] args) {

        //Структура данных для хранения пары ключ - значение
        HashMap<String, Integer> map = new HashMap<>();
        map.put("key1", 123);
        map.put("key2", 124);
        boolean key1 = map.containsKey("key1");

        //Хранение уникальных значений
        HashSet<String> set = new HashSet<>();

        //Хранение пары ключ - значение, в порядке вставки
        LinkedHashMap<Object, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();
        TreeSet<Integer> integers = new TreeSet<>();
        integers.add(5);
        integers.add(2);
        integers.add(3);
        System.out.println(integers);

        //Хранение пары ключ - значение, сортирующее ключи при вставке
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(5, "text");
        treeMap.put(2, "text");
        treeMap.put(3, "text");
        treeMap.forEach((a,b) -> System.out.println(a));

        //Класс сравнивающий значения
        MyComparator myComparator = new MyComparator();
        int compare = myComparator.compare(3, 5);
    }
}
