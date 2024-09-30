package org.labs.Tasks.Task6;

public class Race {
    private String raceName;
    private int attackBonus;
    private int defenseBonus;
    private int healingBonus;
    private int spellBonus;

    public Race(String raceName, int attackBonus, int defenseBonus, int healingBonus, int spellBonus) {
        this.raceName = raceName;
        this.attackBonus = attackBonus;
        this.defenseBonus = defenseBonus;
        this.healingBonus = healingBonus;
        this.spellBonus = spellBonus;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public int getDefenseBonus() {
        return defenseBonus;
    }

    public int getHealingBonus() {
        return healingBonus;
    }

    public int getSpellBonus() {
        return spellBonus;
    }

    @Override
    public String toString() {
        return raceName + " (Attack Bonus: " + attackBonus +
                ", Defense Bonus: " + defenseBonus +
                ", Healing Bonus: " + healingBonus +
                ", Spell Bonus: " + spellBonus + ")";
    }
}

