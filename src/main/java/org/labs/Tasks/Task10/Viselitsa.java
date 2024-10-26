package org.labs.Tasks.Task10;

import java.util.*;

public class Viselitsa {
    private static final List<String> DICTIONARY = Arrays.asList(
            "море", "лес", "город", "река", "гора",
            "дом", "солнце", "звезда", "дерево", "автомобиль",
            "компьютер", "программа", "телефон", "книга", "музыка",
            "игра", "яблоко", "банан", "стол", "стул",
            "окно", "дверь", "кровать", "часы", "картина"
    );

    private static final int MAX_ATTEMPTS = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("Добро пожаловать в игру 'Виселица'!");

        while (playAgain) {
            playGame(scanner);
            playAgain = askToPlayAgain(scanner);
        }

        System.out.println("Спасибо за игру! До свидания.");
        scanner.close();
    }

    private static void playGame(Scanner scanner) {
        String word = getRandomWord().toLowerCase();
        int wordLength = word.length();

        List<Character> currentState = new ArrayList<>();
        for (int i = 0; i < wordLength; i++) {
            currentState.add('_');
        }

        Set<Character> guessedLetters = new HashSet<>();

        int remainingAttempts = MAX_ATTEMPTS;
        boolean isWordGuessed = false;

        while (remainingAttempts > 0 && !isWordGuessed) {
            System.out.println("\nЗагаданное слово: " + displayCurrentState(currentState));

            System.out.print("Введите букву: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.isEmpty()) {
                System.out.println("Вы ничего не ввели. Пожалуйста, введите одну букву.");
                continue;
            }

            if (input.length() > 1){
                System.out.println("Вы ввели не одну букву. Пожалуйста, введите только одну букву.");
                continue;
            }

            char guess = input.charAt(0);

            if (!Character.isLetter(guess)) {
                System.out.println("Пожалуйста, введите только одну букву.");
                continue;
            }

            if (guessedLetters.contains(guess)) {
                System.out.println("Вы уже вводили букву '" + guess + "'. Попробуйте другую.");
                continue;
            }

            guessedLetters.add(guess);

            if (word.indexOf(guess) >= 0) {
                for (int i = 0; i < wordLength; i++) {
                    if (word.charAt(i) == guess) {
                        currentState.set(i, guess);
                    }
                }
                System.out.println("Отлично! Буква '" + guess + "' есть в слове.");

                if (!currentState.contains('_')) {
                    isWordGuessed = true;
                }
            } else {
                remainingAttempts--;
                System.out.println("Неверно! Осталось попыток: " + remainingAttempts);
            }
        }

        if (isWordGuessed) {
            System.out.println("\nПоздравляем! Вы угадали слово: " + word);
        } else {
            System.out.println("\nВы проиграли. Загаданное слово: " + word);
        }
    }

    private static String getRandomWord() {
        Random random = new Random();
        return DICTIONARY.get(random.nextInt(DICTIONARY.size()));
    }

    private static String displayCurrentState(List<Character> currentState) {
        StringBuilder display = new StringBuilder();
        for (char c : currentState) {
            display.append(c).append(' ');
        }
        return display.toString().trim();
    }

    private static boolean askToPlayAgain(Scanner scanner) {
        while (true) {
            System.out.print("\nХотите сыграть еще раз? (да/нет): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("да") || response.equals("д")) {
                return true;
            } else if (response.equals("нет") || response.equals("н")) {
                return false;
            } else {
                System.out.println("Пожалуйста, ответьте 'да' или 'нет'.");
            }
        }
    }
}
