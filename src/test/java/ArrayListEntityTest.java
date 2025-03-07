import com.task.entity.ArrayListEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayListEntityTest {
    ArrayListEntity arrayListEntity;

    @BeforeEach
    public void createList() {
        arrayListEntity = new ArrayListEntity<>();
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
        arrayListEntity.add(testString);
        String actualString = (String) arrayListEntity.get(0);
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
        arrayListEntity.add(15);
        // --- Then ---
        assertEquals(15, arrayListEntity.get(0));
        assertEquals(1, arrayListEntity.size());
    }

    /**
     * Проверяем метод, добавляющий сразу несколько объектов в коллекции
     * When: Добавление объектов int
     * Then: Проверка корректности добавления
     */

    @Test
    public void asList() {
        // --- When ---
        arrayListEntity = ArrayListEntity.asList(5, 10, 15, 20, 25);
        // --- Then ---
        assertEquals(5, arrayListEntity.size());
        assertEquals(15, arrayListEntity.get(2));
        assertEquals(25, arrayListEntity.get(4));
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
        arrayListEntity = ArrayListEntity.asList(15, 25, 35);
        // --- When ---
        arrayListEntity.addByIndex(2, 50);
        // --- Then ---
        assertEquals(50, arrayListEntity.get(2));
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
        arrayListEntity = ArrayListEntity.asList(15, 25, 35);
        // --- When ---
        arrayListEntity.remove(1);
        // --- Then ---
        assertEquals(2, arrayListEntity.size());
        assertEquals(15, arrayListEntity.get(0));
        assertEquals(35, arrayListEntity.get(1));
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
        arrayListEntity = ArrayListEntity.asList(15, 25, 35);
        // --- When ---
        arrayListEntity.clear();
        // --- Then ---
        assertEquals(0, arrayListEntity.size());
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
        arrayListEntity.add(1);
        arrayListEntity.add(2);
        // --- When ---
        arrayListEntity.set(1, 3);
        // --- Then ---
        assertEquals(3, arrayListEntity.get(1));
        assertEquals(1, arrayListEntity.get(0));
    }

    /**
     * Проверка фиксации размера коллекции
     * When: Создание тестовой коллекции
     * Then: Проверка корректности контроля размера
     */

    @Test
    public void size() {
        // --- When ---
        arrayListEntity = ArrayListEntity.asList(15, 25, 35, 45, 55);
        // --- Then ---
        assertEquals(5, arrayListEntity.size());
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
        arrayListEntity = ArrayListEntity.asList(3, 1, 2);
        // --- When ---
        arrayListEntity.sort(Comparator.naturalOrder());
        // --- Then ---
        assertEquals(1, arrayListEntity.get(0));
        assertEquals(2, arrayListEntity.get(1));
        assertEquals(3, arrayListEntity.get(2));
    }

}
