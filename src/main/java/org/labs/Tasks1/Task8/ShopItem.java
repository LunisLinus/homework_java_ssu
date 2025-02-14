package org.labs.Tasks1.Task8;
import java.util.Objects;

public class ShopItem {
    private final String name;
    private final double price;
    private final int quantity;

    public ShopItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "ShopItem{name='" + name + "', price=" + price + ", quantity=" + quantity + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopItem shopItem = (ShopItem) o;

        if (Double.compare(shopItem.price, price) != 0) return false;
        if (quantity != shopItem.quantity) return false;
        return Objects.equals(name, shopItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity);
    }
}
