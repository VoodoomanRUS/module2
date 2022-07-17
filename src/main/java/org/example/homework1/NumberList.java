package org.example.homework1;

import java.lang.reflect.Array;
import java.util.*;

public class NumberList<T extends Number> implements List<T>, RandomAccess {
    private T[] array;
    private int size;

    public NumberList(Class<T> tclass) {
        this.array = (T[]) Array.newInstance(tclass, 1);
    }

    public NumberList(Class<T> tclass, int length) {
        this.array = (T[]) Array.newInstance(tclass, length);
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
    public boolean contains(Object object) {
        for (int i = 0, k = 0; i < size; i++) {
            if (array[i] == null) {
                continue;
            }
            if (array[i].equals(object)) {
                k++;
            }
            if (k >= 2) {
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
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return t1s;
    }

    @Override
    public boolean add(T t) {
        if (array[0] != null) {
            T[] newArray = Arrays.copyOf(array, array.length + 1);
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] == null) {
                    continue;
                }
                newArray[i + 1] = array[i];
                newArray[i] = t;
                array = newArray;
            }
        } else {
            array[0] = t;
        }

        size++;
        return true;
    }

    @Override
    public boolean remove(Object object) {
        boolean flag = false;
        int counter = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j].equals(object)) {
                flag = true;
                array[j] = null;
                counter++;
            }
        }


        T[] newArray = (T[]) new Number[array.length - counter];

        for (int j = 0, k = 0; j < array.length; j++) {
            if (array[j] != null) {
                newArray[k] = array[j];
                k++;
            }
        }
        size = newArray.length;
        array = newArray;
        return flag;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        boolean flag = false;
        int equalsElementsCounter = 0;

        Set<T> temp = new HashSet<>();
        temp.addAll(List.of(array));

        for (int i = 0; i < collection.size(); i++) {
            for (int j = 0; j < temp.size(); j++) {
                if (collection.toArray()[i].equals(temp.toArray()[j])) {
                    equalsElementsCounter++;
                }
            }
        }
        if (equalsElementsCounter == collection.size()) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        T[] tempArray = (T[]) new Number[collection.size()];
        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = (T) collection.toArray()[i];
        }
        T[] newArray = (T[]) new Number[array.length + tempArray.length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        for (int j = array.length, k = 0; j < newArray.length; j++, k++) {
            newArray[j] = tempArray[k];
        }
        array = newArray;
        size += collection.size();
        return size == newArray.length;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {
        boolean flag = false;
        if (index >= array.length) {
            addAll(collection);
            return true;
        } else if (array[index] != null) {
            T[] newArrayPart1 = Arrays.copyOfRange(array, 0, index);
            T[] newArrayPart2 = (T[]) new Number[collection.size()];
            for (int i = 0; i < newArrayPart2.length; i++) {
                newArrayPart2[i] = (T) collection.toArray()[i];
            }
            T[] newArrayPart3 = Arrays.copyOfRange(array, index, array.length);

            T[] newArray = (T[]) new Number[newArrayPart1.length + newArrayPart2.length + newArrayPart3.length];

            System.arraycopy(newArrayPart1, 0, newArray, 0, index);

            for (int i = index, j = 0; j < newArrayPart2.length; i++, j++) {
                newArray[i] = newArrayPart2[j];
            }
            for (int i = newArrayPart1.length + newArrayPart2.length, j = 0; i < newArray.length; i++, j++) {
                newArray[i] = newArrayPart3[j];
            }
            size = newArray.length;
            if ((array.length + collection.size()) == newArray.length) {
                array = newArray;
                flag = true;
            }

            return flag;
        }

        return flag;
    }


    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean flag = false;
        for (Object element :
                collection) {
            flag = remove(element);
        }
        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean flag = false;
        int counter = 0;

        for (int i = 0; i < collection.size(); i++) {
            for (int j = 0; j < array.length; j++) {
                if (collection.toArray()[i].equals(array[j])) {
                    counter++;
                }
            }
        }
        T[] newArray = (T[]) new Number[counter];
        int newCounter = 0;
        for (int i = 0; i < collection.size(); i++) {
            for (int j = 0; j < array.length; j++) {
                if (collection.toArray()[i].equals(array[j])) {
                    newArray[newCounter] = (T) collection.toArray()[i];
                    newCounter++;
                }
            }
        }


        for (Number element :
                newArray) {
            if (element != null) {
                flag = true;
            }
        }
        array = newArray;
        size = array.length;
        return flag;
    }

    @Override
    public void clear() {
        array = (T[]) new Number[0];
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Выход за пределы массива");
        }
        return array[index];
    }

    @Override
    public T set(int index, T element) {
        if (index >= 0 && index < size) {
            array[index] = element;
        }
        return element;
    }

    @Override
    public void add(int index, T element) {
        if (index >= array.length) {
            T[] newArray = (T[]) new Number[index + 1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            newArray[index] = element;
            array = newArray;
            size = index;
        } else if (array[index] != null) {
            T[] newArrayPart1 = Arrays.copyOfRange(array, 0, index);
            T[] newArrayPart2 = Arrays.copyOfRange(array, index, array.length);
            T[] newArray = (T[]) new Number[newArrayPart1.length + newArrayPart2.length + 1];
            System.arraycopy(newArrayPart1, 0, newArray, 0, newArrayPart1.length);
            for (int j = newArrayPart1.length + 1, k = 0; j < newArray.length; j++, k++) {
                newArray[j] = newArrayPart2[k];
            }
            newArray[index] = element;
            size = newArray.length;
            array = newArray;
        }
    }

    @Override
    public T remove(int index) {
        if (index > array.length || index < 0) {
            throw new IndexOutOfBoundsException("Выход за пределы массива");
        } else {
            for (int j = 0; j < array.length; j++) {
                if (array[j].equals(array[index])) {
                    array[j] = null;
                }
            }

            T[] newArray = (T[]) new Number[array.length - 1];

            for (int j = 0, k = 0; j < array.length; j++) {
                if (array[j] != null) {
                    newArray[k] = array[j];
                    k++;
                }
            }
            array = newArray;
            return array[index];
        }
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
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
    public List<T> subList(int fromIndex, int toIndex) {
        return Arrays.asList(Arrays.copyOfRange(array, fromIndex, toIndex));
    }

    public Double getDouble(int index) {
        if (index >= 0 && index < array.length) {
            if (array[index].equals(Double.class)) {
                return (Double) array[index];
            } else {
                throw new NoSuchElementException("Неверный тип данных");
            }
        } else {
            throw new IndexOutOfBoundsException("Выход за пределы массива");
        }
    }

    public Integer sumIntegers() {
        int sum = 0;
        for (Number element :
                array) {
            if (element.getClass() == Integer.class) {
                sum += (Integer) element;
            }
        }
        return sum;
    }
}
