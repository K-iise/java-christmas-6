package christmas.service;

import christmas.domain.Menu;
import christmas.domain.Order;
import java.util.ArrayList;
import java.util.List;

public class WeekdayDiscount implements DiscountPolicy {

    @Override
    public int calculate(Order order) {
        int date = order.getDate() % 7 + 1;
        int discount = 0;
        List<Integer> weekday = new ArrayList<>(
                List.of(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31));

        if (date >= 1) {
            if (weekday.contains(date)) {
                for (String name : order.getMenu().keySet()) {
                    Menu menu = Menu.fromName(name);
                    if (menu.getCategory().equals("디저트")) {
                        discount += order.getMenu().get(name) * 2023;
                        order.addDiscount(order.getMenu().get(name) * 2023);
                    }
                }
            }
        }
        return discount;
    }
}
