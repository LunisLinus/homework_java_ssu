package org.labs.Tasks1.Task21;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<String> filteredWords = Utils.filter(words, s -> s.startsWith("b"));
        System.out.println("Отфильтрованные слова (начинаются с 'b'): " + filteredWords);

        List<Integer> numbers = Arrays.asList(5, 12, 7, 20, 3, 15);
        List<Integer> filteredNumbers = Utils.filter(numbers, n -> n > 10);
        System.out.println("Числа больше 10: " + filteredNumbers);

        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        );
        List<Person> filteredPeople = Utils.filter(people, person -> person.getAge() >= 30);
        System.out.println("Люди старше или равные 30 лет: " + filteredPeople);

        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "blueberry", "avocado");
        List<String> filteredFruits = Utils.filter(fruits, Main::isFruitStartingWithA);
        System.out.println("Фрукты, начинающиеся с 'a': " + filteredFruits);
    }

    public static boolean isFruitStartingWithA(String s) {
        return s.toLowerCase().startsWith("a");
    }
}


