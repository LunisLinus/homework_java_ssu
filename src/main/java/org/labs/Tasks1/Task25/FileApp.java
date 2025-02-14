package org.labs.Tasks1.Task25;

import java.util.Scanner;

public class FileApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileProcessor processor = new FileProcessor();

        System.out.println("Добро пожаловать в приложение управления файлами!");

        while (true) {
            System.out.print("\nВведите команду (save [path], list, saveLocal [id], exit): ");
            String input = scanner.nextLine();
            String[] parts = input.trim().split("\\s+", 2);
            String command = parts[0].toLowerCase();

            switch (command) {
                case "save":
                    if (parts.length < 2) {
                        System.out.println("Пожалуйста, укажите путь к файлу или папке.");
                    } else {
                        String path = parts[1];
                        processor.processFiles(path);
                    }
                    break;

                case "list":
                    processor.listFiles();
                    break;

                case "savelocal":
                    if (parts.length < 2) {
                        System.out.println("Пожалуйста, укажите ID файла.");
                    } else {
                        try {
                            int id = Integer.parseInt(parts[1]);
                            processor.saveLocal(id);
                        } catch (NumberFormatException e) {
                            System.out.println("Неверный формат ID. Пожалуйста, введите числовое значение.");
                        }
                    }
                    break;

                case "exit":
                    System.out.println("Завершение работы приложения.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Неизвестная команда. Доступные команды: save, list, saveLocal, exit.");
            }
        }
    }
}
