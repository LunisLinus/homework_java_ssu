package org.labs.Tasks.Task6;

public class Priest extends Player implements Healer {
    public Priest(String name, Race race) {
        super(name, 90, 10 + race.getAttackBonus(), 7 + race.getDefenseBonus(), race);
    }

    @Override
    public void heal(Player target) {
        if (!this.isAlive) {
            System.out.println(name + " is dead and cannot heal.");
            return;
        }
        System.out.println(name + " heals " + target.name + ".");
        target.increaseHealth(25 + race.getHealingBonus());
    }

    @Override
    public String toString() {
        return "Priest{" +
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
