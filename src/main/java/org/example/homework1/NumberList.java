package org.example.homework1;

import java.lang.reflect.Array;
import java.util.*;

public class NumberList<T extends Number> implements List<T> {
    private T[] array;
    private int size;

    public NumberList(Class<T> tclass) {
        this.array = (T[]) Array.newInstance(tclass, 10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (this.isEmpty() == true) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {


        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    @Override
    public boolean add(T t) {


        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Выход за пределы массива");
        }
        return array[i];
    }

    @Override
    public T set(int i, T t) {
        return null;
    }

    @Override
    public void add(int i, T t) {
        size = array.length;
        if (i > array.length || size == 0) {
            T[] newArray = (T[]) new Number[i + 1];
            newArray[i] = t;
            array = newArray;
        } else {
            if (array[i].equals(Number.class)) {
                T[] newArrayPart1 = Arrays.copyOfRange(array, 0, i);
                T[] newArrayPart2 = Arrays.copyOfRange(array, i + 1, array.length);
                T[] newArray = (T[]) new Number[(newArrayPart1.length + 1) + newArrayPart2.length];
                for (int j = 0; j < newArrayPart1.length; j++) {
                    newArray[j] = newArrayPart1[j];
                }
                for (int j = 0; j < newArray.length; j++) {
                    newArray[j + newArrayPart1.length + 1] = newArrayPart1[j];
                }
            }


        }


    }

    @Override
    public T remove(int i) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        return null;
    }

    @Override
    public List<T> subList(int i, int i1) {
        return null;
    }
}
