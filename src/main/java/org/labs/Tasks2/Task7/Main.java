package org.labs.Tasks2.Task7;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        Producer producer = new Producer("Производитель-1", warehouse);
        Consumer consumer = new Consumer("Потребитель-1", warehouse);

        producer.start();
        consumer.start();
    }
}
