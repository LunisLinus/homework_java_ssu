package org.labs.Tasks.Task19;

// Utils.java

import java.util.Arrays;
import java.util.List;

public class Utils {
    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть null или пустым");
        }

        T max = array[0];
        for (T element : array) {
            if (element == null) {
                continue; // Игнорируем null
            }
            if (max == null || element.compareTo(max) > 0) {
                max = element;
            }
        }

        if (max == null) {
            throw new IllegalArgumentException("Массив содержит только null элементы");
        }

        return max;
    }

    public static <T extends Comparable<T>> T findMax(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Список не должен быть null или пустым");
        }

        T max = null;
        for (T element : list) {
            if (element == null) {
                continue; // Игнорируем null
            }
            if (max == null || element.compareTo(max) > 0) {
                max = element;
            }
        }

        if (max == null) {
            throw new IllegalArgumentException("Список содержит только null элементы");
        }

        return max;
    }
}
