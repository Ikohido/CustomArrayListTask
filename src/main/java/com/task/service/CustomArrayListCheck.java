package com.task.service;

import com.task.entity.ArrayListEntity;

import java.util.stream.IntStream;

// Класс создан для проверки работы коллекции под воздействием циклов
public class CustomArrayListCheck {
    ArrayListEntity arrayListEntity = new ArrayListEntity();

    // Проверка работоспособности при внедрении в коллекцию большого кол-ва значений.
    public void checkLogic() {
        // Добавление элементов от 0 до 1499
        IntStream.range(0, 1500).forEach(arrayListEntity::add);
        System.out.println(arrayListEntity);

        // Удаление элементов от 0 до 1489
        IntStream.range(0, 1490).forEach(i -> arrayListEntity.remove(0));
        System.out.println(arrayListEntity);

        // Очистка коллекции и проверка очистки
        arrayListEntity.clear();
        System.out.println(arrayListEntity);
    }

}
