package org.labs.Tasks1.Task4;

// Класс Cube (Куб)
public class Cube extends Shape {
    private final double side;

    public Cube(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Сторона должна быть положительным числом.");
        }
        this.side = side;
    }

    @Override
    public double getVolume() {
        return Math.pow(side, 3);
    }

    @Override
    public String toString() {
        return "Куб (сторона = " + side + ")";
    }
}
