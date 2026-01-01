package christmas.domain;

import java.util.HashMap;

public class Order {
    private final int date;
    private final int price;
    private int discount = 0;
    private final HashMap<String, Integer> menu;

    public Order(int date, int price, HashMap<String, Integer> menu) {
        this.date = date;
        this.price = price;
        this.menu = menu;
    }

    public int getDate() {
        return date;
    }

    public HashMap<String, Integer> getMenu() {
        return menu;
    }

    public int getPrice() {
        return price;
    }

    public void addDiscount(int discount) {
        this.discount += discount;
    }

    public int getDiscount() {
        return discount;
    }
}
