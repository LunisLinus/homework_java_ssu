package org.labs.Tasks2.Task13;

class AirConditioner {
    private final String location;
    public AirConditioner(String location) {
        this.location = location;
    }
    public void on() {
        System.out.println("Кондиционер в " + location + " включен.");
    }
    public void off() {
        System.out.println("Кондиционер в " + location + " выключен.");
    }
}

