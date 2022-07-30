package org.example.lesson2;

import org.example.homework1.NumberList;

import java.util.Arrays;
import java.util.List;

public class Homework1 {
    public static void main(String[] args) {
        NumberList<Number> myNewList = new NumberList<>(Number.class);

        for (int i = 0; i < 10; i++) {
            myNewList.add(i, 5);
        }
        System.out.println(Arrays.toString(myNewList.toArray()));
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
