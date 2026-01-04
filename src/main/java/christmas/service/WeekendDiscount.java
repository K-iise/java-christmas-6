package christmas.service;

import christmas.domain.Menu;
import christmas.domain.Order;

public class WeekendDiscount implements DiscountPolicy {
    @Override
    public int calculate(Order order) {
        if (!isWeekend(order)) {
            return 0;
        }
        int totaldiscount = 0;
        for (String name : order.getMenu().keySet()) {
            totaldiscount += calculateItemDiscount(name, order.getMenu().get(name));
        }
        return totaldiscount;
    }

    private int calculateItemDiscount(String menuName, int quantity) {
        Menu menu = Menu.fromName(menuName);
        if (menu.getCategory().equals("메인")) {
            return quantity * 2023;
        }
        return 0;
    }

    private boolean isWeekend(Order order) {
        int dayOfWeekend = order.getDate() % 7;
        return dayOfWeekend == 1 || dayOfWeekend == 2;
    }
}
