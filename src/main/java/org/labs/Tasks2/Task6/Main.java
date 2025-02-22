package org.labs.Tasks2.Task6;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RailwayCrossing crossing = new RailwayCrossing();

        Car car1 = new Car("Car-1", crossing);
        Car car2 = new Car("Car-2", crossing);
        Car car3 = new Car("Car-3", crossing);

        Train train = new Train("Train-1", crossing);

        car1.start();
        car2.start();

        Thread.sleep(1000);

        train.start();

        Thread.sleep(500);
        car3.start();
    }
}

