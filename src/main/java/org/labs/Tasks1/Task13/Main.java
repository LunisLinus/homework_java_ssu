package org.labs.Tasks1.Task13;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<User> users = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            users = UserManager.loadUsers();
            if (users.isEmpty()) {
                System.out.println("Список пользователей пуст или файл не найден. Начинаем с пустого списка.");
            } else {
                System.out.println("Список пользователей успешно загружен из файла.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке пользователей: " + e.getMessage());
            users = new ArrayList<>();
        }

        System.out.println("Добро пожаловать в систему управления пользователями!");

        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    addNewUser();
                    break;
                case 2:
                    showAllUsers();
                    break;
                case 3:
                    saveUsersToFile();
                    break;
                case 4:
                    loadUsersFromFile();
                    break;
                case 5:
                    searchUserByName();
                    break;
                case 6:
                    removeUser();
                    break;
                case 7:
                    exitProgram();
                    exit = true;
                    break;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nВыберите действие:");
        System.out.println("1. Добавить нового пользователя");
        System.out.println("2. Показать всех пользователей");
        System.out.println("3. Сохранить список пользователей в файл");
        System.out.println("4. Загрузить список пользователей из файла");
        System.out.println("5. Найти пользователя по имени");
        System.out.println("6. Удалить пользователя из списка");
        System.out.println("7. Выйти");
        System.out.print("\nВведите номер действия: ");
    }

    private static int getUserChoice() {
        int choice = -1;
        String input = scanner.nextLine().trim();
        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException ignored) {
        }
        return choice;
    }

    private static void addNewUser() {
        System.out.print("Введите имя пользователя: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Имя не может быть пустым. Пользователь не добавлен.");
            return;
        }

        int age = -1;
        while (age < 0) {
            System.out.print("Введите возраст: ");
            String ageInput = scanner.nextLine().trim();
            try {
                age = Integer.parseInt(ageInput);
                if (age < 0) {
                    System.out.println("Возраст не может быть отрицательным. Пожалуйста, попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите целое число.");
            }
        }

        String email = "";
        while (true) {
            System.out.print("Введите email: ");
            email = scanner.nextLine().trim();
            if (isValidEmail(email)) {
                break;
            } else {
                System.out.println("Некорректный формат email. Пожалуйста, попробуйте снова.");
            }
        }

        User user = new User(name, age, email);
        users.add(user);
        System.out.println("Пользователь добавлен.");
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[^\\.@]+@[^\\.@]+\\.[^\\.@]+$";
        return email.matches(emailRegex);
    }

    private static void showAllUsers() {
        if (users.isEmpty()) {
            System.out.println("Список пользователей пуст.");
        } else {
            System.out.println("Список пользователей:");
            int index = 1;
            for (User user : users) {
                System.out.println(index + ". " + user);
                index++;
            }
        }
    }

    private static void saveUsersToFile() {
        try {
            UserManager.saveUsers(users);
            System.out.println("Список успешно сохранён в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении списка: " + e.getMessage());
        }
    }

    private static void loadUsersFromFile() {
        try {
            users = UserManager.loadUsers();
            if (users.isEmpty()) {
                System.out.println("Список пользователей пуст или файл не найден.");
            } else {
                System.out.println("Список успешно загружен из файла.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке списка: " + e.getMessage());
            users = new ArrayList<>();
        }
    }

    private static void searchUserByName() {
        System.out.print("Введите имя для поиска: ");
        String searchName = scanner.nextLine().trim().toLowerCase();

        if (searchName.isEmpty()) {
            System.out.println("Имя для поиска не может быть пустым.");
            return;
        }

        List<User> foundUsers = new ArrayList<>();
        for (User user : users) {
            if (user.getName().toLowerCase().contains(searchName)) {
                foundUsers.add(user);
            }
        }

        if (foundUsers.isEmpty()) {
            System.out.println("Пользователи с именем \"" + searchName + "\" не найдены.");
        } else {
            System.out.println("Найденные пользователи:");
            int index = 1;
            for (User user : foundUsers) {
                System.out.println(index + ". " + user);
                index++;
            }
        }
    }

    private static void removeUser() {
        if (users.isEmpty()) {
            System.out.println("Список пользователей пуст.");
            return;
        }

        showAllUsers();
        System.out.print("Введите номер пользователя для удаления: ");
        String input = scanner.nextLine().trim();
        int index = -1;
        try {
            index = Integer.parseInt(input);
            if (index < 1 || index > users.size()) {
                System.out.println("Некорректный номер пользователя.");
                return;
            }
            User removedUser = users.remove(index - 1);
            System.out.println("Пользователь \"" + removedUser.getName() + "\" удалён.");
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод. Пожалуйста, введите целое число.");
        }
    }

    private static void exitProgram() {
        try {
            UserManager.saveUsers(users);
            System.out.println("Данные сохранены. Программа завершена. До свидания!");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных при выходе: " + e.getMessage());
            System.out.println("Программа завершена без сохранения некоторых данных. До свидания!");
        }
    }
}
