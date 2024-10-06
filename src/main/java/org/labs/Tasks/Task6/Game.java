package org.labs.Tasks.Task6;

public class Game {
    public static void main(String[] args) {
        Race human = new Race("Human", 5, 5, 5, 5);
        Race elf = new Race("Elf", 10, 3, 10, 15);
        Race orc = new Race("Orc", 15, 10, 2, 0);

        Warrior warrior = new Warrior("Some Ork", orc, 5);
        Guard guard = new Guard("Guard Ork", orc, 5, 10);
        Mage mage = new Mage("Some Mage", elf);
        Priest priest = new Priest("Some Healer", human);

        System.out.println(warrior);
        System.out.println(guard);
        System.out.println(mage);
        System.out.println(priest);
        System.out.println();

        warrior.move(3, 4);
        mage.move(1, 1);
        priest.move(2, 2);
        System.out.println();

        warrior.attack(mage);
        priest.heal(mage);
        mage.castSpell(warrior);

        warrior.move(10, 10);
        warrior.attack(priest);

        System.out.println();

        System.out.println(warrior);
        System.out.println(guard);
        System.out.println(mage);
        System.out.println(priest);
    }
}

