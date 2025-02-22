package org.labs.Tasks2.Task4;

public class GasStation {
    private int availableColumns = 2;

    public synchronized void refuel(String carName) throws InterruptedException {
        while (availableColumns == 0) {
            System.out.println(carName + " ждет освобождения колонки...");
            wait();
        }

        availableColumns--;
        System.out.println(carName + " начинает заправку. Свободных колонок осталось: " + availableColumns);

        Thread.sleep((long) (Math.random() * 3000 + 1000));

        availableColumns++;
        System.out.println(carName + " завершила заправку. Свободных колонок теперь: " + availableColumns);

        notifyAll();
    }
}
