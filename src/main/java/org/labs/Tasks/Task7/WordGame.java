package org.labs.Tasks.Task7;

import java.util.*;

public class WordGame {
    public static void playGame(DictionaryStatistic stats) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Игра в слова:");
        System.out.print("Введите слово: ");
        String inputWord = scanner.nextLine().toLowerCase();

        Map<Character, Integer> inputLetterCount = getLetterCount(inputWord);

        List<String> possibleWords = new ArrayList<>();

        for (String word : stats.words) {
            String lowerWord = word.toLowerCase();
            Map<Character, Integer> wordLetterCount = getLetterCount(lowerWord);

            if (canFormWord(inputLetterCount, wordLetterCount)) {
                possibleWords.add(word);
            }
        }

        possibleWords.removeIf(word -> word.equalsIgnoreCase(inputWord));

        if (possibleWords.isEmpty()) {
            System.out.println("Нет доступных слов, которые можно составить из введенного слова.");
        } else {
            System.out.println("Варианты слов:");
            for (String word : possibleWords) {
                System.out.println(word);
            }
        }

        scanner.close();
    }

    private static Map<Character, Integer> getLetterCount(String word) {
        Map<Character, Integer> letterCount = new HashMap<>();
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
            }
        }
        return letterCount;
    }

    private static boolean canFormWord(Map<Character, Integer> available, Map<Character, Integer> required) {
        for (Map.Entry<Character, Integer> entry : required.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            if (available.getOrDefault(c, 0) < count) {
                return false;
            }
        }
        return true;
    }
}

