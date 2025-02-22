package org.labs.Tasks2.Task8;

public class Main {
    public static void main(String[] args) {
        Object lock = new Object();

        TrafficLight trafficLight = new TrafficLight(lock);
        trafficLight.start();

        Car car1 = new Car("Car-1", trafficLight, lock);
        Car car2 = new Car("Car-2", trafficLight, lock);
        Car car3 = new Car("Car-3", trafficLight, lock);

        car1.start();
        car2.start();
        car3.start();
    }
}

