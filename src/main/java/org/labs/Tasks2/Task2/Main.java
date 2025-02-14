package org.labs.Tasks2.Task2;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new Espresso();
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");

        coffee = new SizeDecorator(coffee, "medium");
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");

        coffee = new Milk(coffee);
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");

        coffee = new Caramel(coffee);
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");

        coffee = new Chocolate(coffee);
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");
    }
}
