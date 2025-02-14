package org.labs.Tasks1.Task6;

public class Warrior extends Player implements Attacker {
    protected int attackRadius;

    public Warrior(String name, Race race, int attackRadius) {
        super(name, 150, 20 + race.getAttackBonus(), 10 + race.getDefenseBonus(), race);
        this.attackRadius = attackRadius;
    }

    @Override
    public void attack(Player target) {
        if (!this.isAlive) {
            System.out.println(name + " is dead and cannot attack.");
            return;
        }
        double distance = Math.sqrt(Math.pow(this.posX - target.posX, 2) + Math.pow(this.posY - target.posY, 2));
        if (distance > attackRadius) {
            System.out.println(name + " cannot attack " + target.name + ". Target is out of range.");
            return;
        }
        System.out.println(name + " attacks " + target.name + ".");
        target.decreaseHealth(damage + race.getAttackBonus());
    }

    @Override
    public String toString() {
        return "Warrior{" +
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
                '}';
    }
}

