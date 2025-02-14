package org.labs.Tasks1.Task15;

public class SeasonApp {
    public static void main(String[] args) {
        System.out.println("Информация о временах года:");
        for (Season season : Season.values()) {
            String seasonName = getSeasonName(season);
            System.out.println(seasonName + ": " + season.getTemperature() + ", типичный праздник - " + season.getTypicalHoliday());
        }
    }

    private static String getSeasonName(Season season) {
        switch (season) {
            case SPRING:
                return "Весна";
            case SUMMER:
                return "Лето";
            case AUTUMN:
                return "Осень";
            case WINTER:
                return "Зима";
            default:
                return season.name();
        }
    }
}

