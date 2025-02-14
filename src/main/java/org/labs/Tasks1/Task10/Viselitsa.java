package org.labs.Tasks1.Task10;

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
            String word = chooseGameMode(scanner);
            playGame(scanner, word);
            playAgain = askToPlayAgain(scanner);
        }

        System.out.println("Спасибо за игру! До свидания.");
        scanner.close();
    }

    private static String chooseGameMode(Scanner scanner) {
        while (true) {
            System.out.println("\nВыберите режим игры:");
            System.out.println("1. Одиночный (компьютер загадывает слово)");
            System.out.println("2. Двухигровой (один игрок загадывает слово)");
            System.out.print("Введите 1 или 2: ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                return getRandomWord().toLowerCase();
            } else if (choice.equals("2")) {
                return getWordFromPlayer(scanner);
            } else {
                System.out.println("Неверный выбор. Пожалуйста, введите 1 или 2.");
            }
        }
    }

    private static String getWordFromPlayer(Scanner scanner) {
        System.out.print("Игрок 1, введите слово для угадывания: ");
        String word = scanner.nextLine().trim().toLowerCase();

        while (word.isEmpty() || !word.matches("[а-яё]+")) {
            System.out.println("Неверный ввод. Пожалуйста, введите слово только из букв русского алфавита.");
            System.out.print("Попробуйте снова: ");
            word = scanner.nextLine().trim().toLowerCase();
        }

        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

        return word;
    }

    private static void playGame(Scanner scanner, String word) {
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
