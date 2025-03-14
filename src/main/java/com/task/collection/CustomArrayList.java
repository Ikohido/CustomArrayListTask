package com.task.collection;

import com.task.service.SortLogic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
Ниже показана реализация своего ArrayList с необходимыми базовыми методами
для работы и конструкторами.
 */
public class CustomArrayList<T> {
    // Текущий размер коллекции
    private int size;
    // Массив встроенный в наш ArrayList
    private Object[] objects;

    // Получение объекта по индексу
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) objects[index];
    }

    // Добавление объекта в конец списка
    public void add(T t) {
        if (size == objects.length) {
            upgrade();
        }
        objects[size] = t;
        size++;
    }

    // Добавление объекта по индексу
    public void add(int index, T t) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        if (size == objects.length) {
            upgrade();
        }
        for (int i = size; i > index; i--) {
            objects[i] = objects[i - 1];
        }
        objects[index] = t;
        size++;
    }

    // Метод, аналогичный Arrays.asList()
    public static <T> CustomArrayList<T> asList(T... elements) {
        CustomArrayList<T> list = new CustomArrayList<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }

    // Удаление объекта по индексу
    public void remove(int index) {
        Objects.checkIndex(index, size);
        for (int i = index; i < size - 1; i++) {
            objects[i] = objects[i + 1];
        }
        objects[size - 1] = null;
        size--;
    }

    // Очищение всей коллекции
    public void clear() {
        Arrays.fill(objects, 0, size, null);
        size = 0;
    }

    // Замена элемента коллекции по индексу
    public void set(int index, T element) {
        Objects.checkIndex(index, size);
        objects[index] = element;
    }

    // Конструктор коллекции по умолчанию
    public CustomArrayList() {
        objects = new Object[10];
        size = 0;
    }
    public CustomArrayList(int capacity){
        if (capacity < 0) {
            throw new IllegalArgumentException("Размер коллекции не должен быть отрицательным");
        }
        objects = new Object[size];
        this.size = 0;
    }

    // Текущий размер коллекции
    public int size() {
        return size;
    }

    // Автоматическое увеличение массива после исчерпания размера по умолчанию
    private void upgrade() {
        objects = Arrays.copyOf(objects, objects.length * 2);
    }

    // Сортировка коллекции
    public void sort(Comparator<? super T> comparator) {
        SortLogic.sort((T[]) objects, 0, size - 1, comparator);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(objects, size));
    }
}
