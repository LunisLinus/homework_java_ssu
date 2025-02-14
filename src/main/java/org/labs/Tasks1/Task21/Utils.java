package org.labs.Tasks1.Task21;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Utils {
    public static <T> List<T> filter(List<T> elements, Predicate<T> predicate) {
        if (elements == null) {
            throw new IllegalArgumentException("Список элементов не должен быть null");
        }
        if (predicate == null) {
            throw new IllegalArgumentException("Предикат не должен быть null");
        }

        List<T> filteredList = new ArrayList<>();
        for (T element : elements) {
            if (predicate.test(element)) {
                filteredList.add(element);
            }
        }
        return filteredList;
    }
}

