package org.labs.Tasks.Task1;

public class Main1 {
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
