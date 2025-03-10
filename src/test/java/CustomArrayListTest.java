import com.task.collection.CustomArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Ниже написаны тесты для всех методов кастомного ArrayList
 */
public class CustomArrayListTest {
    CustomArrayList customArrayList;

    @BeforeEach
    public void createList() {
        customArrayList = new CustomArrayList<>();
    }

    /**
     * Проверяем получение из коллекции
     * Given: Создание тестовой строки
     * When: Добавление и получение тестовой строки
     * Then: Проверка того, что строка вытащена корректно
     */
    @Test
    public void get() {
        // --- Given ---
        String testString = "testString";
        // --- When ---
        customArrayList.add(testString);
        String actualString = (String) customArrayList.get(0);
        // --- Then ---
        assertEquals(testString, actualString);
    }

    /**
     * Проверяем добавление в коллекцию
     * When: Добавляем тестовый int
     * Then: Проверяем корректность добавления
     */

    @Test
    public void add() {
        // --- When ---
        customArrayList.add(15);
        // --- Then ---
        assertEquals(15, customArrayList.get(0));
        assertEquals(1, customArrayList.size());
    }

    /**
     * Проверяем метод, добавляющий сразу несколько объектов в коллекции
     * When: Добавление объектов int
     * Then: Проверка корректности добавления
     */

    @Test
    public void asList() {
        // --- When ---
        customArrayList = CustomArrayList.asList(5, 10, 15, 20, 25);
        // --- Then ---
        assertEquals(5, customArrayList.size());
        assertEquals(15, customArrayList.get(2));
        assertEquals(25, customArrayList.get(4));
    }

    /**
     * Проверяем добавление по индексу
     * Given: Добавление тестовых значений
     * When: Заменяем значение определенного индекса
     * Then: Проверяем корректность добавления
     */

    @Test
    public void addByIndex() {
        // --- Given ---
        customArrayList = CustomArrayList.asList(15, 25, 35);
        // --- When ---
        customArrayList.add(2, 50);
        // --- Then ---
        assertEquals(50, customArrayList.get(2));
    }

    /**
     * Проверяем удаление из коллекции
     * Given: Создание тестовой коллекции
     * When: Удаление значения из индекса 1
     * Then: Проверка корректности удаления
     */

    @Test
    public void remove() {
        // --- Given ---
        customArrayList = CustomArrayList.asList(15, 25, 35);
        // --- When ---
        customArrayList.remove(1);
        // --- Then ---
        assertEquals(2, customArrayList.size());
        assertEquals(15, customArrayList.get(0));
        assertEquals(35, customArrayList.get(1));
    }

    /**
     * Проверяем очистку коллекции
     * Given: Создание тестовой коллекции
     * When: Очистка коллекции
     * Then: Проверка очистки
     */
    @Test
    public void сlear() {
        // --- Given ---
        customArrayList = CustomArrayList.asList(15, 25, 35);
        // --- When ---
        customArrayList.clear();
        // --- Then ---
        assertEquals(0, customArrayList.size());
    }

    /**
     * Проверяем замену значения по индексу
     * Given: Создание тестовой коллекции
     * When: Замена значения
     * Then: Проверка корректности замены
     */
    @Test
    public void set() {
        // --- Given ---
        customArrayList.add(1);
        customArrayList.add(2);
        // --- When ---
        customArrayList.set(1, 3);
        // --- Then ---
        assertEquals(3, customArrayList.get(1));
        assertEquals(1, customArrayList.get(0));
    }

    /**
     * Проверка фиксации размера коллекции
     * When: Создание тестовой коллекции
     * Then: Проверка корректности контроля размера
     */

    @Test
    public void size() {
        // --- When ---
        customArrayList = CustomArrayList.asList(15, 25, 35, 45, 55);
        // --- Then ---
        assertEquals(5, customArrayList.size());
    }

    /**
     * Проверяем сортировку
     * Given: Создание тестовой коллекции
     * When: Сортировка
     * Then: Проверка корректности сортировки
     */

    @Test
    public void sort() {
        // --- Given ---
        customArrayList = CustomArrayList.asList(3, 1, 2);
        // --- When ---
        customArrayList.sort(Comparator.naturalOrder());
        // --- Then ---
        assertEquals(1, customArrayList.get(0));
        assertEquals(2, customArrayList.get(1));
        assertEquals(3, customArrayList.get(2));
    }

}
