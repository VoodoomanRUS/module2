package org.example.lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Lesson2 {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>(String.class);
        System.out.println(Arrays.toString(list.toArray()));
        list.add("hello");
        list.add("hello2");
        list.add("hello3");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("hello2");
        list2.add("hello3");
        list2.add("hello4");
        list2.add("hello5");
        list2.add("hello6");

        System.out.println(list.containsAll(list2));
        list.addAll(list2);
        System.out.println(list);

        int hello2 = list.indexOf("hello2");
        int hello = list.lastIndexOf("hello");
        System.out.println(hello2);
        System.out.println(hello);


    }
}
