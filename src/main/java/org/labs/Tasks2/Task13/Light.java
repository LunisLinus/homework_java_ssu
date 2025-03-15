package org.labs.Tasks2.Task13;

class Light {
    private final String location;
    public Light(String location) {
        this.location = location;
    }
    public void on() {
        System.out.println("Свет в " + location + " включен.");
    }
    public void off() {
        System.out.println("Свет в " + location + " выключен.");
    }
}

