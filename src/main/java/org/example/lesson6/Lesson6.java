package org.example.lesson6;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

public class Lesson6 {

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException, InstantiationException {
        Object petr = new User6(5, "Petr");
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Alexey");

        //Перебор полей
        for (Field field : petr.getClass().getSuperclass().getDeclaredFields()) {
            if (map.containsKey(field.getName())) {
                //Сделать поле публичным
                field.setAccessible(true);
                field.set(petr, map.get(field.getName()));
                Object o = field.get(petr);
                System.out.println(o);
            }
        }

        //Преобразование объекта
        User6 castedInstance = getCastedInstance(petr, User6.class);

        //Загрузчик классов
        Class<?> user6 = petr.getClass().getClassLoader().loadClass("org.example.lesson6.User6");

        //Перебор вложенных классов
        Arrays.stream(petr.getClass().getClasses()).forEach(e -> System.out.println(e));

        //Получение конструктора
        Constructor<?> constructor = petr.getClass().getConstructor(Integer.class, String.class);
        constructor.setAccessible(true);

        //Создание объекта
        Object yuri = constructor.newInstance(2, "Yuri");
        User6 casted = User6.class.cast(yuri);


        //Получение объявленных методов
        Method[] declaredMethods = yuri.getClass().getDeclaredMethods();
        Method method = yuri.getClass().getDeclaredMethod("getCount", null);

        long start = System.currentTimeMillis();
        //Запуск метода
        Object invoke = method.invoke(yuri, null);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        //Обработка аннотаций (вставка значения из аннотации в запуск метода)
        petr = new User6(1, "Petr");
        for (Method declaredMethod : petr.getClass().getDeclaredMethods()) {
            if (declaredMethod.getName().equals("setCount")) {
                if (declaredMethod.isAnnotationPresent(Min.class)) {
                    Min annotation = declaredMethod.getAnnotation(Min.class);
                    int values = annotation.values();
                    declaredMethod.invoke(petr, values);
                }
            }
        }

        //Обработка аннотаций (проверка на null)
        AbstractUser abstractUser = new AbstractUser(null);
        Field[] declaredFields = abstractUser.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(NonNull.class)) {
                declaredField.setAccessible(true);
                if (declaredField.get(abstractUser) == null) {
                    throw new RuntimeException("Field " + declaredField.getName() + " is marked nonNull, but is null");
                }
            }
        }
    }

    public static <T> T getCastedInstance(Object obj, Class<T> clazz) {
        return clazz.cast(obj);
    }

}
