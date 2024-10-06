package org.labs.Tasks.Task7;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DictionaryStatistic {
    String[] words;
    private int dictionarySize;
    private int polindrom;
    private int maxWordLength;
    private int minWordLength;
    private final char[] alphabet;
    private final int[] frequency;

    public DictionaryStatistic(String[] words, char[] alphabet) {
        this.words = words;
        this.alphabet = alphabet;
        this.frequency = new int[alphabet.length];
    }

    public void calculateStatistics() {
        dictionarySize = words.length;
        polindrom = 0;
        maxWordLength = 0;
        minWordLength = Integer.MAX_VALUE;

        for (String word : words) {
            String lowerWord = word.toLowerCase();
            if (isPalindrome(lowerWord)) {
                polindrom++;
            }

            int length = lowerWord.length();
            if (length > maxWordLength) {
                maxWordLength = length;
            }
            if (length < minWordLength) {
                minWordLength = length;
            }

            for (char c : lowerWord.toCharArray()) {
                for (int i = 0; i < alphabet.length; i++) {
                    if (c == alphabet[i]) {
                        frequency[i]++;
                        break;
                    }
                }
            }
        }
    }

    private boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String getRandomWord() {
        Random random = new Random();
        int index = random.nextInt(dictionarySize);
        return words[index];
    }

    public void printSymbolsStat() {
        System.out.println("Статистика по буквам алфавита:");
        for (int i = 0; i < alphabet.length; i++) {
            System.out.println(alphabet[i] + " - " + frequency[i]);
        }
    }

    public int getDictionarySize() {
        return dictionarySize;
    }

    public int getPolindrom() {
        return polindrom;
    }

    public int getMaxWordLength() {
        return maxWordLength;
    }

    public int getMinWordLength() {
        return minWordLength;
    }

}

