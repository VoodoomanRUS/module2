package org.example.lesson2;

import org.example.homework1.NumberList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Homework1 {
    public static void main(String[] args) {
        Number toRemove = 888;


        NumberList<Number> myNewList = new NumberList<>(Number.class);
        System.out.println(Arrays.toString(myNewList.toArray()));
        System.out.println(myNewList.size());

        myNewList.add(909090909090L);
        System.out.println(Arrays.toString(myNewList.toArray()));
        System.out.println(myNewList.size());


        for (int i = 0; i < 3; i++) {
            myNewList.add(i + 1);
            System.out.println(Arrays.toString(myNewList.toArray()));
            System.out.println(myNewList.size());
        }
        System.out.println(Arrays.toString(myNewList.toArray()));
        System.out.println(myNewList.size());



        myNewList.add(2, 888);
        myNewList.add(0, 888);
        myNewList.add(0, 666);
        myNewList.add(0, 555);
        System.out.println(Arrays.toString(myNewList.toArray()));
        System.out.println(myNewList.size());

        myNewList.set(0, 999);
        System.out.println(Arrays.toString(myNewList.toArray()));
        System.out.println(myNewList.size());


        System.out.println(myNewList.contains(888));

        System.out.println(myNewList.get(0));
//        System.out.println(myNewList.remove(toRemove));

//        myNewList.remove(2);
        System.out.println(Arrays.toString(myNewList.toArray()));
        System.out.println(myNewList.size());






        List<Number> myNewSublist = new ArrayList<>(myNewList.subList(1, 4));
        System.out.println(myNewSublist);
        System.out.println(myNewSublist.size());

        myNewSublist.add(909090);
        System.out.println(myNewSublist);
        System.out.println(myNewSublist.size());

        System.out.println(myNewList.containsAll(myNewSublist));


        System.out.println(myNewList.addAll(myNewSublist));
        System.out.println(myNewSublist);
        System.out.println(myNewSublist.size());



        System.out.println(myNewList.addAll(4, myNewSublist));
        System.out.println(myNewSublist);
        System.out.println(myNewSublist.size());

        System.out.println(Arrays.toString(myNewList.toArray()));
        System.out.println(myNewList.size());

        System.out.println(myNewList.retainAll(myNewSublist));

        System.out.println(Arrays.toString(myNewList.toArray()));
        System.out.println(myNewList.size());

//        System.out.println(myNewList.getDouble(1));
//        System.out.println(myNewList.sumIntegers());

        //Создать свою реализацию List - (Number list). Она может работать только с Numbers (Generics)
        //Особенности переопределения методов
        //1. Метод add - который добавляет в начало массива
        //2. Метод remove - удаляет все элементы массив
        //3. Метод contains - возвращает true, только если таких элементов больше или равно 2
        //
        //Особенности новых методов
        //1. Метод getDouble(int index), будет возвращать элемент типа Double по указанному индексу, или кидать ошибку
        //2. Метод sumIntegers(), будет давать сумму всех чисел, если array - Integer, иначе кидать ошибку

        //Опциально(По желанию)
        //Закончить MyList класс - дописать оставшиешься методы, кроме итератор и toArray()
    }
}
