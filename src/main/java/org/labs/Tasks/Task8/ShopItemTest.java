package org.labs.Tasks.Task8;
import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;


public class ShopItemTest {
    public static void main(String[] args) {
        String[] names = {"книга", "ручка", "линейка", "пенал"};
        double[] prices = {15.0, 25.0, 35.0, 45.0};
        int[] quantities = {5, 10, 15, 20};
        Random random = new Random();

        ShopItem[] items = new ShopItem[100];

        List<ShopItem> predefinedItems = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String name = names[random.nextInt(names.length)];
            double price = prices[random.nextInt(prices.length)];
            int quantity = quantities[random.nextInt(quantities.length)];
            predefinedItems.add(new ShopItem(name, price, quantity));
        }

        for (int i = 0; i < items.length; i++) {
            if (random.nextDouble() < 0.3) {
                items[i] = predefinedItems.get(random.nextInt(predefinedItems.size()));
            } else {
                String name = names[random.nextInt(names.length)];
                double price = 10.0 + (90.0 * random.nextDouble());
                int quantity = random.nextInt(10) + 1;
                items[i] = new ShopItem(name, price, quantity);
            }
        }

        Arrays.sort(items, Comparator.comparing(ShopItem::getName));

        for (ShopItem item : items) {
            System.out.println(item);
        }

        Map<ShopItem, Integer> itemCount = new HashMap<>();

        for (ShopItem item : items) {
            itemCount.put(item, itemCount.getOrDefault(item, 0) + 1);
        }

        int duplicateCount = 0;
        for (Map.Entry<ShopItem, Integer> entry : itemCount.entrySet()) {
            int count = entry.getValue();
            if (count > 1) {
                duplicateCount += count - 1;
            }
        }

        System.out.println("Количество одинаковых ShopItem: " + duplicateCount);
    }
}
