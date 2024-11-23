package org.labs.Tasks.Task16;


enum Suit {
    PEAKS("Пики"),
    WORMS("Черви"),
    DIAMONDS("Бубны"),
    CLUBS("Трефы");

    private final String displayName;

    Suit(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
