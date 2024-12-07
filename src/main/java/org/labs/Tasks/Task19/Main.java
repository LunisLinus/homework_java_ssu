package org.labs.Tasks.Task19;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};
        try {
            Integer maxNumber = Utils.findMax(numbers);
            System.out.println("Максимальное число: " + maxNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        String[] words = {"apple", "banana", "cherry"};
        try {
            String maxWord = Utils.findMax(words);
            System.out.println("Максимальное слово: " + maxWord);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        Double[] decimals = {2.5, 3.6, 1.2, 4.8, 3.3};
        try {
            Double maxDecimal = Utils.findMax(decimals);
            System.out.println("Максимальное число с плавающей точкой: " + maxDecimal);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        String[] emptyArray = {};
        try {
            String max = Utils.findMax(emptyArray);
            System.out.println("Максимальное слово: " + max);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        String[] arrayWithNulls = {"apple", null, "banana", "cherry"};
        try {
            String maxWithNulls = Utils.findMax(arrayWithNulls);
            System.out.println("Максимальное слово (с null): " + maxWithNulls);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        List<String> wordList = Arrays.asList("delta", "alpha", "charlie", "bravo");
        try {
            String maxFromList = Utils.findMax(wordList);
            System.out.println("Максимальное слово из списка: " + maxFromList); // Выведет: delta
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        List<String> listWithNulls = Arrays.asList("delta", null, "charlie", "bravo");
        try {
            String maxFromListWithNulls = Utils.findMax(listWithNulls);
            System.out.println("Максимальное слово из списка (с null): " + maxFromListWithNulls);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        String[] allNulls = {null, null, null};
        try {
            String maxAllNulls = Utils.findMax(allNulls);
            System.out.println("Максимальное слово из массива только с null: " + maxAllNulls);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
