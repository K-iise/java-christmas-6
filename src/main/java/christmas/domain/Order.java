package christmas.domain;

import java.util.HashMap;

public class Order {
    private final int date;
    private final HashMap<String, Integer> menu;

    public Order(int date, HashMap<String, Integer> menu) {
        this.date = date;
        this.menu = menu;
    }
}
