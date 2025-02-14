package org.labs.Tasks1.Task9;

import java.util.Scanner;

class InputWithTimeout {
    private Scanner scanner;
    private String input = null;

    public InputWithTimeout(Scanner scanner, long timeoutMillis) {
        this.scanner = scanner;
        Thread thread = new Thread(() -> {
            if (scanner.hasNextLine()) {
                input = scanner.nextLine();
            }
        });
        thread.start();
        try {
            thread.join(timeoutMillis);
        } catch (InterruptedException ignored) {
        }
        if (thread.isAlive()) {
            thread.interrupt();
        }
    }

    public String getInput() {
        return input;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
