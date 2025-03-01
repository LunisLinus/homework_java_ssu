package org.labs.Tasks2.Task10;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class RunnerRace {

    public static final int DEFAULT_NUM_RUNNERS = 5;
    public static AtomicBoolean raceInterrupted = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {
        int numRunners = DEFAULT_NUM_RUNNERS;
        if (args.length > 0) {
            try {
                numRunners = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный аргумент. Используется значение по умолчанию: " + DEFAULT_NUM_RUNNERS);
            }
        }

        CyclicBarrier startBarrier = new CyclicBarrier(numRunners, () ->
                System.out.println("Все участники готовы. Начинаем забег!")
        );

        CyclicBarrier finishBarrier = new CyclicBarrier(numRunners, () ->
                System.out.println("Все бегуны финишировали. Забег завершён!")
        );

        ExecutorService executor = Executors.newFixedThreadPool(numRunners);
        for (int i = 0; i < numRunners; i++) {
            executor.submit(new Runner("Бегун-" + (i + 1), startBarrier, finishBarrier));
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        if (raceInterrupted.get()) {
            System.out.println("Забег был прерван из-за травмы одного из бегунов.");
        }
    }
}
