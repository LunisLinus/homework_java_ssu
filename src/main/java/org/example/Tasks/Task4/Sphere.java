package org.example.Tasks.Task4;

public class Sphere extends Shape {
    private final double radius;

    public Sphere(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным числом.");
        }
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public String toString() {
        return "Сфера (радиус = " + radius + ")";
    }
}
