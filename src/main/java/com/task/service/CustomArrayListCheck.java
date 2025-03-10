package com.task.service;

import com.task.collection.CustomArrayList;

import java.util.stream.IntStream;

/**
 * Класс ниже создан для проверки работы коллекции под воздействием циклов
 */
public class CustomArrayListCheck {
    CustomArrayList customArrayList = new CustomArrayList();

    // Проверка работоспособности при внедрении в коллекцию большого кол-ва значений.
    public void checkLogic() {
        // Добавление элементов от 0 до 1499
        IntStream.range(0, 1500).forEach(customArrayList::add);
        System.out.println(customArrayList);

        // Удаление элементов от 0 до 1489
        IntStream.range(0, 1490).forEach(i -> customArrayList.remove(0));
        System.out.println(customArrayList);

        // Очистка коллекции и проверка очистки
        customArrayList.clear();
        System.out.println(customArrayList);
    }

}
