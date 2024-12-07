package org.labs.Tasks.Task20;

public class Main {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        integerBox.add(10);
        integerBox.add(20);
        integerBox.add(30);
        System.out.println("Содержимое integerBox: " + integerBox);
        System.out.println("Сумма integerBox: " + integerBox.sum());

        Box<Double> doubleBox = new Box<>();
        doubleBox.add(1.5);
        doubleBox.add(2.5);
        doubleBox.add(3.0);
        System.out.println("Содержимое doubleBox: " + doubleBox);
        System.out.println("Сумма doubleBox: " + doubleBox.sum());

        Box<Float> floatBox = new Box<>();
        floatBox.add(2.2f);
        floatBox.add(3.8f);
        System.out.println("Содержимое floatBox: " + floatBox);
        System.out.println("Сумма floatBox: " + floatBox.sum());

        Box<Long> longBox = new Box<>();
        longBox.add(100L);
        longBox.add(200L);
        longBox.add(300L);
        System.out.println("Содержимое longBox: " + longBox);
        System.out.println("Сумма longBox: " + longBox.sum());

        Box<Integer> emptyBox = new Box<>();
        System.out.println("Содержимое emptyBox: " + emptyBox);
        System.out.println("Сумма emptyBox: " + emptyBox.sum());

        Box<Integer> boxWithNull = new Box<>();
        boxWithNull.add(10);
        boxWithNull.add(null);
        boxWithNull.add(20);
        System.out.println("Содержимое boxWithNull: " + boxWithNull);
        System.out.println("Сумма boxWithNull: " + boxWithNull.sum());

        integerBox.clear();
        System.out.println("Содержимое integerBox после очистки: " + integerBox);
        System.out.println("Сумма integerBox после очистки: " + integerBox.sum());

        System.out.println("Первый элемент doubleBox: " + doubleBox.get(0));
    }
}
