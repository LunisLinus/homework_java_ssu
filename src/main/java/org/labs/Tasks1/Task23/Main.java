package org.labs.Tasks1.Task23;

public class Main {
    public static void main(String[] args) {
        Integer number = 123;
        Utils.printType(number);

        String text = "Hello";
        Utils.printType(text);

        Double decimal = 45.67;
        Utils.printType(decimal);

        Boolean flag = true;
        Utils.printType(flag);

        Person person = new Person("Alice", 30);
        Utils.printType(person);

        Utils.printType(null);

        int[] array = {1, 2, 3};
        Utils.printType(array);

        java.util.List<String> list = java.util.Arrays.asList("apple", "banana");
        Utils.printType(list);
    }
}

