package org.labs.Tasks2.Task4;

public class Main {
    public static void main(String[] args) {
        GasStation gasStation = new GasStation();

        for (int i = 1; i <= 10; i++) {
            Car car = new Car("Car-" + i, gasStation);
            car.start();
        }
    }
}
