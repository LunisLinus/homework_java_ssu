package org.labs.Tasks.Task7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/dictionary.txt"));
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();
                if (!word.isEmpty()) {
                    wordList.add(word);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Файл dictionary.txt не найден.");
            e.printStackTrace();
            return;
        }

        String[] words = wordList.toArray(new String[0]);
        char[] alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();

        DictionaryStatistic stats = new DictionaryStatistic(words, alphabet);
        stats.calculateStatistics();

        System.out.println("Размер словаря: " + stats.getDictionarySize());
        System.out.println("Количество палиндромов: " + stats.getPolindrom());
        System.out.println("Максимальная длина слова: " + stats.getMaxWordLength());
        System.out.println("Минимальная длина слова: " + stats.getMinWordLength());

        stats.printSymbolsStat();

        WordGame.playGame(stats);
    }
}

