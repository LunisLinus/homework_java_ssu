package org.example.Tasks;

public class Task1 {
    // Вывести на экран числа от 1 до 100 через запятую, переходя на новую строку каждые 10 чисел
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.print(i);

            if (i < 100) {
                System.out.print(", ");
            }

            if (i % 10 == 0) {
                System.out.print("\n");
            }
        }
    }
}
