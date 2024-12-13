package org.labs.Tasks.Task24;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final UserService userService = new UserService();

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в приложение управления пользователями!");
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Введите команду: ");
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split("\\s+", 2);
            String command = parts[0].toLowerCase();

            try {
                switch (command) {
                    case "add":
                        if (parts.length < 2) {
                            System.out.println("Использование: add \"[name]\" [email]");
                        } else {
                            handleAdd(parts[1]);
                        }
                        break;
                    case "list":
                        handleList();
                        break;
                    case "delete":
                        if (parts.length < 2) {
                            System.out.println("Использование: delete [id]");
                        } else {
                            handleDelete(parts[1]);
                        }
                        break;
                    case "update":
                        if (parts.length < 2) {
                            System.out.println("Использование: update [id] \"[new_name]\" [new_email]");
                        } else {
                            handleUpdate(parts[1]);
                        }
                        break;
                    case "exit":
                        System.out.println("Завершение работы приложения.");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Неизвестная команда. Доступные команды: add, list, delete, update, exit.");
                }
            } catch (IllegalArgumentException | SQLException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private static void handleAdd(String input) throws SQLException {
        Pattern pattern = Pattern.compile("^\"([^\"]+)\"\\s+(\\S+)$");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String name = matcher.group(1);
            String email = matcher.group(2);
            userService.registerUser(name, email);
        } else {
            System.out.println("Некорректный формат команды. Используйте: add \"[name]\" [email]");
        }
    }

    private static void handleList() throws SQLException {
        List<User> users = userService.listAllUsers();
        if (users.isEmpty()) {
            System.out.println("Список пользователей пуст.");
        } else {
            users.forEach(System.out::println);
        }
    }

    private static void handleDelete(String input) throws SQLException {
        try {
            int id = Integer.parseInt(input);
            userService.deleteUser(id);
        } catch (NumberFormatException e) {
            System.out.println("ID должен быть числом.");
        }
    }

    private static void handleUpdate(String input) throws SQLException {
        Pattern pattern = Pattern.compile("^(\\d+)\\s+\"([^\"]+)\"\\s+(\\S+)$");
        Matcher matcher = pattern.matcher(input);


        if (matcher.find()) {
            int id = Integer.parseInt(matcher.group(1));
            String newName = matcher.group(2);
            String newEmail = matcher.group(3);
            userService.updateUser(id, newName, newEmail);
        } else {
            System.out.println("Некорректный формат команды. Используйте: update [id] \"[new_name]\" [new_email]");
        }
    }
}
