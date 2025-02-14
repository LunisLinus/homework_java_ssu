package org.labs.Tasks1.Task6;

public class Guard extends Warrior {
    private int additionalDefense;

    public Guard(String name, Race race, int attackRadius, int additionalDefense) {
        super(name, race, attackRadius);
        this.name = name;
        this.additionalDefense = additionalDefense;
        this.defense += additionalDefense;
    }

    @Override
    public void decreaseHealth(int value) {
        if (!isAlive) {
            System.out.println(name + " is already dead.");
            return;
        }
        int totalDefense = defense + additionalDefense + race.getDefenseBonus();
        currentHealth = currentHealth + totalDefense - value;
        System.out.println(name + " (Guard) received " + value + " damage. Total defense: " + totalDefense + ". Current health: " + currentHealth);
        if (currentHealth <= 0) {
            isAlive = false;
            currentHealth = 0;
            System.out.println(name + " (Guard) has died.");
        }
    }

    @Override
    public String toString() {
        return "Guard{" +
                "name='" + name + '\'' +
                ", currentHealth=" + currentHealth +
                ", maxHealth=" + maxHealth +
                ", isAlive=" + isAlive +
                ", posX=" + posX +
                ", posY=" + posY +
                ", damage=" + damage +
                ", defense=" + defense +
                ", race=" + race +
                ", attackRadius=" + attackRadius +
                ", additionalDefense=" + additionalDefense +
                '}';
    }
}
