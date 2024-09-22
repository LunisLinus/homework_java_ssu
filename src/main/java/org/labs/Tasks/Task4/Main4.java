package org.labs.Tasks.Task4;

public class Main4 {
    public static void main(String[] args) {
        Container container = new Container(1000.0);
        System.out.println(container);

        Shape sphere = new Sphere(5);
        Shape cube = new Cube(8);
        Shape cylinder = new Cylinder(3, 10);

        System.out.println(container.add(sphere));
        System.out.println(container.add(cube));
        System.out.println(container.add(cylinder));

        System.out.println("\nСодержимое контейнера:");
        for (Shape shape : container.getShapes()) {
            System.out.println(shape.toString() + " с объёмом " + String.format("%.2f", shape.getVolume()));
        }

        System.out.println("\nОставшийся объём в контейнере: " + String.format("%.2f", container.getRemainingVolume()));
    }
}
