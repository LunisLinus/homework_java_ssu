package org.labs.Tasks2.Task11;

public class Main {
    public static void main(String[] args) {
        Stock teslaStock = new Stock("Tesla", 700);
        Stock appleStock = new Stock("Apple", 150);

        MobileApp mobileApp = new MobileApp("Ivan");
        EmailNotifier emailNotifier = new EmailNotifier("ivan@example.com");

        teslaStock.subscribe(mobileApp);
        teslaStock.subscribe(emailNotifier);
        appleStock.subscribe(emailNotifier);

        teslaStock.setPrice(710);
        appleStock.setPrice(155);

        teslaStock.unsubscribe(emailNotifier);

        teslaStock.setPrice(720);
    }
}
