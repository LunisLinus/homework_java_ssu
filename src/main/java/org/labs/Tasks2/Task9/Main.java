package org.labs.Tasks2.Task9;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static final String POISON_PILL = "POISON_PILL";

    public static void main(String[] args) {

        BlockingQueue<String> stampingQueue   = new ArrayBlockingQueue<>(5);
        BlockingQueue<String> assemblingQueue = new ArrayBlockingQueue<>(5);
        BlockingQueue<String> warehouseQueue  = new ArrayBlockingQueue<>(5);

        Thread stampingWorker  = new Thread(new StampingWorker(stampingQueue), "Штамповщик");
        Thread assemblingWorker = new Thread(new AssemblingWorker(stampingQueue, assemblingQueue), "Сборщик");
        Thread qualityWorker   = new Thread(new QualityWorker(assemblingQueue, warehouseQueue), "Оператор контроля");
        Thread shipmentWorker  = new Thread(new ShipmentWorker(warehouseQueue), "Грузчик");

        stampingWorker.start();
        assemblingWorker.start();
        qualityWorker.start();
        shipmentWorker.start();
    }
}
