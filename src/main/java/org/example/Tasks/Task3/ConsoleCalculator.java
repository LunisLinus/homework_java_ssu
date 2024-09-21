package org.example.Tasks.Task3;

import java.util.Scanner;

public class ConsoleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        System.out.println("Консольный калькулятор. Введите 'exit' для выхода.");

        while (true) {
            try {
                System.out.print("Введите первое число: ");
                String inputA = scanner.nextLine();
                if (inputA.equalsIgnoreCase("exit")) {
                    break;
                }
                double a = Double.parseDouble(inputA);

                System.out.print("Введите оператор (+, -, *, /): ");
                String operator = scanner.nextLine();
                if (operator.equalsIgnoreCase("exit")) {
                    break;
                }
                if (!operator.matches("[+\\-*/]")) {
                    System.out.println("Неверный оператор. Попробуйте снова.");
                    continue;
                }

                System.out.print("Введите второе число: ");
                String inputB = scanner.nextLine();
                if (inputB.equalsIgnoreCase("exit")) {
                    break;
                }
                double b = Double.parseDouble(inputB);

                double result;
                switch (operator) {
                    case "+":
                        result = calculator.add(a, b);
                        break;
                    case "-":
                        result = calculator.subtract(a, b);
                        break;
                    case "*":
                        result = calculator.multiply(a, b);
                        break;
                    case "/":
                        result = calculator.divide(a, b);
                        break;
                    default:
                        System.out.println("Неподдерживаемый оператор.");
                        continue;
                }

                System.out.println("Результат: " + result);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода: Пожалуйста, введите корректные числа.");
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
            }

            System.out.println();
        }

        System.out.println("Калькулятор завершил работу.");
        scanner.close();
    }
}
