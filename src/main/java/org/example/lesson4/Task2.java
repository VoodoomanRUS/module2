package org.example.lesson4;

import org.example.homework2.MyUser;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {
    public static void main(String[] args) {
        //Дан лист
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 5, 8, 8, 9);
        Random random = new Random(1);
        integers.stream()
                .filter(e -> e > 4)
                .distinct()
                .map(e -> new MyUser(e, Stream.generate(() -> random.nextInt(10)).limit(e)
                        .collect(Collectors.toList())))
                .map(MyUser::getUserList)
                .flatMap(Collection::stream)
                .map(e -> e * 10)
                .reduce(Integer::sum)
                .ifPresentOrElse(System.out::println, () -> System.out.println(0));

        //Задача №1
        //Создать класс пользователей, каждый из которых будет иметь порядковый номер, и список с числами
        //С помощью stream api:
        // 1. Оставить только числа больше 4 из integers
        // 2. Убрать дубликаты чисел
        // 3. Создать пользователей на каждый элемент стрима, где каждый элемент стрима
        // является порядковым номером пользователя.
        // 4. У каждого пользователя заполнить список чисел: количество чисел в списке
        // определяется порядковым номером пользователя. Например: для пользователя с порядковым номером 5
        // генерируется пять случайных чисел используя переменную random ( в диапазоне до 10 ).
        // 5. Создать единый стрим со всеми числами из списков пользователей.
        // 6. Умножить числа на 10
        // 7. Посчитать сумму всех чисел с помощью reduce
        // 8. Вывести на экран
        // 9. В случае если integers пустой, то должно выводиться на экран "0"
        // Внимание! Все операции должны выполняться одной цепочкой integers.stream().map() ...
        // никаких переменных не должно появиться
        // Ожидаемый результат вывода на экран:
        // 1120 - из примера, 0 - при пустом листе

        List<List<Integer>> lists = List.of(List.of(1, 2), List.of(3, 4, 5), List.of());


        //Задача №2
        // 1. Отсортировать список lists так, чтобы сначала были самые большие списки по размеру
        // 2. Вывести на экран все элементы
        // Ожидаемый результат: 3,4,5,1,2

        lists.stream()
                .sorted((e, e1) -> e1.size() - e.size())
                .flatMap(Collection::stream)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //Задача №3
        // 1. Узнать, есть ли в lists хотя бы один список, который содержит сумму всех элементов вложенного листа
        // равную 12

        System.out.println(lists.stream().anyMatch(e -> e.stream().reduce(Integer::sum).orElse(0).equals(12)));


    }
}
