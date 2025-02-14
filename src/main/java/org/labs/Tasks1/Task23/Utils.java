package org.labs.Tasks1.Task23;

public class Utils {

    public static <T> void printType(T obj) {
        if (obj == null) {
            System.out.println("Объект равен null");
        } else {
            System.out.println("Тип объекта: " + obj.getClass().getName());
        }
    }
}

