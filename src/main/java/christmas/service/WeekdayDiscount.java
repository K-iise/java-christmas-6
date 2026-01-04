package christmas.service;

import christmas.domain.Menu;
import christmas.domain.Order;

public class WeekdayDiscount implements DiscountPolicy {

    @Override
    public int calculate(Order order) {
        if (isWeekday(order)) {
            return 0;
        }
        int discount = 0;
        for (String name : order.getMenu().keySet()) {
            discount += calculateItemDiscount(name, order.getMenu().get(name));
        }
        return discount;
    }

    private boolean isWeekday(Order order) {
        int dayOfWeek = order.getDate() % 7;
        return dayOfWeek != 1 && dayOfWeek != 2;
    }

    private int calculateItemDiscount(String name, int quantity) {
        Menu menu = Menu.fromName(name);
        if (menu.getCategory().equals("디저트")) {
            return quantity * 2023;
        }
        return 0;
    }
}
