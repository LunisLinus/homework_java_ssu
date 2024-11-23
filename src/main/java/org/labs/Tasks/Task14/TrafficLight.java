package org.labs.Tasks.Task14;

public enum TrafficLight {
    RED, YELLOW, GREEN;

    public TrafficLight getNextLight() {
        switch (this) {
            case RED:
                return GREEN;
            case GREEN:
                return YELLOW;
            case YELLOW:
                return RED;
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
    }
}

