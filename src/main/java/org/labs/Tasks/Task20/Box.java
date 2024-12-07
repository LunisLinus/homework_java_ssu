package org.labs.Tasks.Task20;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Number> {
    private final List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public double sum() {
        double total = 0.0;
        for (T element : elements) {
            if (element != null) { // Проверка на null
                total += element.doubleValue();
            }
        }
        return total;
    }

    public int size() {
        return elements.size();
    }

    public void clear() {
        elements.clear();
    }

    public T get(int index) {
        return elements.get(index);
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
