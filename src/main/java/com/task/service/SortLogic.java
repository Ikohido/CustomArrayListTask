package com.task.service;

import java.util.Comparator;

import static java.util.Objects.compare;

/**
 * Реализация QuickSort сортировки
 */
public class SortLogic {

    // Сам алгоритм QuickSort
    public static <T> void sort(T[] array, int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            int Index = partition(array, low, high, comparator);
            sort(array, low, Index - 1, comparator);
            sort(array, Index + 1, high, comparator);
        }
    }

    // Разделение коллекции на 2 части для алгоритма QuickSort
    private static <T> int partition(T[] array, int low, int high, Comparator<? super T> comparator) {
        T pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compare(array[j], pivot, comparator) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    // Меняет местами 2 элемента коллекции
    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
