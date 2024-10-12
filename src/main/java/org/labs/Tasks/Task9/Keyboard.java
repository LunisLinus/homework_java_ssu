package org.labs.Tasks.Task9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Keyboard {

    public static void main(String[] args) {
        String path = "src/main/resources/dictionary.txt";
        List<String> words = getWords(path);

        if (words.isEmpty()) {
            System.out.println("Список слов пуст или файл не найден.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalWords = 0;
        int correctWords = 0;
        int totalChars = 0;

        long startTime = System.currentTimeMillis();
        long endTime = startTime + 60_000;

        System.out.println("Начните вводить слова. У вас есть 1 минута.");
        System.out.println("Введите слово и нажмите Enter:");

        while (System.currentTimeMillis() < endTime) {
            String targetWord = words.get(random.nextInt(words.size()));
            System.out.println("Введите слово: " + targetWord);

            long currentTime = System.currentTimeMillis();
            if (currentTime >= endTime) {
                break;
            }

            long timeLeft = endTime - currentTime;
            InputWithTimeout inputWithTimeout = new InputWithTimeout(scanner, timeLeft);
            String userInput = inputWithTimeout.getInput();

            if (userInput == null) {
                break;
            }

            totalWords++;
            totalChars += userInput.length();

            if (userInput.equalsIgnoreCase(targetWord)) {
                correctWords++;
            }
        }

        System.out.println("\nВремя вышло!");
        System.out.println("Всего слов: " + totalWords);
        System.out.println("Правильных слов: " + correctWords);
        System.out.println("Введено символов: " + totalChars);
        System.out.printf("Скорость: %.2f символов в секунду%n", (double) totalChars / 60);

        scanner.close();
    }

    public static List<String> getWords(String path) {
        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + path);
        }
        return words;
    }
}
