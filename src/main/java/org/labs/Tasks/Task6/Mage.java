package org.labs.Tasks.Task6;

public class Mage extends Player implements SpellCaster {
    public Mage(String name, Race race) {
        super(name, 100, 15 + race.getAttackBonus(), 5 + race.getDefenseBonus(), race);
    }

    @Override
    public void castSpell(Player target) {
        if (!this.isAlive) {
            System.out.println(name + " is dead and cannot cast spells.");
            return;
        }
        System.out.println(name + " casts a spell on " + target.name + ".");
        target.decreaseHealth(20 + race.getSpellBonus());
    }

    @Override
    public String toString() {
        return "Mage{" +
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
