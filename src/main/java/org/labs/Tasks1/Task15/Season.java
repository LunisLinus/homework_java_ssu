package org.labs.Tasks1.Task15;

public enum Season {
    SPRING("Тепло", "Пасха"),
    SUMMER("Жарко", "День Независимости"),
    AUTUMN("Прохладно", "День учителя"),
    WINTER("Холодно", "Новый год");

    private final String temperature;
    private final String typicalHoliday;

    Season(String temperature, String typicalHoliday) {
        this.temperature = temperature;
        this.typicalHoliday = typicalHoliday;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getTypicalHoliday() {
        return typicalHoliday;
    }
}
