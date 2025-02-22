package org.labs.Tasks2.Task5;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        Chef chef = new Chef("Повар-1", restaurant);
        Waiter waiter = new Waiter("Официант-1", restaurant);

        chef.start();
        waiter.start();
    }
}
