package org.labs.Tasks2.Task13;

class TV {
    private final String location;
    public TV(String location) {
        this.location = location;
    }
    public void on() {
        System.out.println("Телевизор в " + location + " включен.");
    }
    public void off() {
        System.out.println("Телевизор в " + location + " выключен.");
    }
}