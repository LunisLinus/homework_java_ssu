package org.labs.Tasks1.Task11;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.Set;
import java.util.NavigableSet;

public class StudentManager {
    private final Set<String> students = new TreeSet<>();

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.run();
    }

    public void run() {
        while (true) {
            printMenu();
            int option = getOption();

            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    displayAllStudents();
                    break;
                case 4:
                    findStudent();
                    break;
                case 5:
                    findStudentsInRange();
                    break;
                case 6:
                    System.out.println("Выход из программы. До свидания!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректная опция. Пожалуйста, выберите снова.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Добавить студента");
        System.out.println("2. Удалить студента");
        System.out.println("3. Показать всех студентов");
        System.out.println("4. Найти студента");
        System.out.println("5. Найти студентов по диапазону");
        System.out.println("6. Выйти");
        System.out.print("Выберите опцию: ");
    }

    private int getOption() {
        while (!scanner.hasNextInt()) {
            System.out.println("Пожалуйста, введите число от 1 до 6.");
            scanner.next();
            System.out.print("Выберите опцию: ");
        }
        return scanner.nextInt();
    }

    private void addStudent() {
        scanner.nextLine();
        System.out.print("Введите имя студента (например, 'Иванов Иван'): ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Имя студента не может быть пустым.");
            return;
        }

        if (students.contains(name)) {
            System.out.println("Студент с именем '" + name + "' уже существует.");
        } else {
            students.add(name);
            System.out.println("Студент добавлен.");
        }
    }

    private void removeStudent() {
        scanner.nextLine();
        System.out.print("Введите имя студента для удаления: ");
        String name = scanner.nextLine().trim();

        if (students.remove(name)) {
            System.out.println("Студент удален.");
        } else {
            System.out.println("Студент с именем '" + name + "' не найден.");
        }
    }

    private void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст.");
            return;
        }

        System.out.println("Список студентов:");
        students.forEach(System.out::println);
    }

    private void findStudent() {
        scanner.nextLine();
        System.out.print("Введите имя студента для поиска: ");
        String name = scanner.nextLine().trim();

        if (students.contains(name)) {
            System.out.println("Студент найден.");
        } else {
            System.out.println("Студент с именем '" + name + "' не найден.");
        }
    }

    private void findStudentsInRange() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст.");
            return;
        }

        scanner.nextLine();
        System.out.print("Введите имя первого студента из диапазона: ");
        String first = scanner.nextLine().trim();

        System.out.print("Введите имя второго студента из диапазона: ");
        String second = scanner.nextLine().trim();

        if (first.compareTo(second) > 0) {
            String temp = first;
            first = second;
            second = temp;
        }

        NavigableSet<String> range = ((TreeSet<String>) students).subSet(first, true, second, true);

        if (range.isEmpty()) {
            System.out.println("В заданном диапазоне студентов нет.");
        } else {
            System.out.println("Студенты в диапазоне от '" + first + "' до '" + second + "':");
            range.forEach(System.out::println);
        }
    }
}
