package org.labs.Tasks2.Task4;

public class Main {
    public static void main(String[] args) {
        int totalCars = 10;
        GasStation gasStation = new GasStation(totalCars);

        for (int i = 1; i <= totalCars; i++) {
            Car car = new Car("Car-" + i, gasStation);
            car.start();
        }
    }
}