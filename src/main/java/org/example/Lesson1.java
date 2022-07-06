package org.example;

import org.example.computer.*;
import org.example.store.Fork;
import org.example.store.Store;
import org.example.store.UsbAdapter;
import org.example.store.Vodka;

import java.util.HashMap;
import java.util.Map;

public class Lesson1 {

    public static void main(String[] args) {
        Fork fork = new Fork();
        Vodka vodka = new Vodka();
        UsbAdapter usbAdapter = new UsbAdapter();

        Store<Fork> forkStore = new Store<>(fork);
        Fork fork1 = forkStore.getGood();
        fork1.push();

        Map<String, Object> map = new HashMap<>();
        map.put("name", "Yuri");
        map.put("age", 28);
        map.put("isYoung", true);

        Tv tv = new Tv();
        KeyBoard keyBoard = new KeyBoard();
        Mouse mouse = new Mouse();
        Monitor monitor = new Monitor();

        Computer<Mouse, Monitor> computer1 = new Computer<>(mouse, monitor);
        computer1.getInput().move();
        computer1.getOutput().showMon();

        //Аналог без дженерика
        String text = "x";
        Object change = change((Object) text);
        String change1 = (String) change;
    }

    public static Object change(Object text) {
        return text;
    }

    //Статический метод с дженериком
    public static <T> T changeGeneric(T text) {
        return text;
    }
}
