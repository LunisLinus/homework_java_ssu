package org.labs.Tasks1.Task4;

import java.util.ArrayList;
import java.util.List;


public class Container {
    private final double totalVolume;
    private double remainingVolume;
    private final List<Shape> shapes;

    public Container(double totalVolume) {
        if (totalVolume <= 0) {
            throw new IllegalArgumentException("Объём контейнера должен быть положительным числом.");
        }
        this.totalVolume = totalVolume;
        this.remainingVolume = totalVolume;
        this.shapes = new ArrayList<>();
    }
    public String add(Shape shape) {
        double shapeVolume = shape.getVolume();
        if (shapeVolume <= remainingVolume) {
            shapes.add(shape);
            remainingVolume -= shapeVolume;
            return "Фигура " + shape.toString() + " добавлена. Остаток объёма: " + String.format("%.2f", remainingVolume);
        } else {
            return "Невозможно добавить фигуру " + shape.toString() + ". Недостаточно места.";
        }
    }

    public List<Shape> getShapes() {
        return new ArrayList<>(shapes);
    }

    public double getRemainingVolume() {
        return remainingVolume;
    }

    @Override
    public String toString() {
        return "Контейнер (общий объём = " + totalVolume + ", оставшийся объём = " + String.format("%.2f", remainingVolume) + ")";
    }
}

