package org.labs.Tasks1.Task6;

public abstract class Player {
    protected String name;
    protected int currentHealth;
    protected int maxHealth;
    protected boolean isAlive;
    protected int posX;
    protected int posY;
    protected int damage;
    protected int defense;
    protected Race race;

    public Player(String name, int maxHealth, int damage, int defense, Race race) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.isAlive = true;
        this.posX = 0;
        this.posY = 0;
        this.damage = damage;
        this.defense = defense;
        this.race = race;
    }

    public void increaseHealth(int value) {
        if (!isAlive) {
            System.out.println(name + " is dead and cannot be healed.");
            return;
        }
        currentHealth += value + race.getHealingBonus();
        if (currentHealth > maxHealth) {
            currentHealth = maxHealth;
        }
        System.out.println(name + " healed by " + (value + race.getHealingBonus()) + " points. Current health: " + currentHealth);
    }

    public void decreaseHealth(int value) {
        if (!isAlive) {
            System.out.println(name + " is already dead.");
            return;
        }
        int totalDefense = defense + race.getDefenseBonus();
        currentHealth = currentHealth + totalDefense - value;
        System.out.println(name + " received " + value + " damage. Total defense: " + totalDefense + ". Current health: " + currentHealth);
        if (currentHealth <= 0) {
            isAlive = false;
            currentHealth = 0;
            System.out.println(name + " has died.");
        }
    }

    public void move(int deltaX, int deltaY) {
        posX += deltaX;
        posY += deltaY;
        System.out.println(name + " moved to position (" + posX + ", " + posY + ").");
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", currentHealth=" + currentHealth +
                ", maxHealth=" + maxHealth +
                ", isAlive=" + isAlive +
                ", posX=" + posX +
                ", posY=" + posY +
                ", damage=" + damage +
                ", defense=" + defense +
                ", race=" + race +
                '}';
    }
}

