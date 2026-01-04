package christmas.service;

import christmas.domain.Event;
import christmas.domain.Menu;
import christmas.domain.Order;
import java.util.ArrayList;
import java.util.List;

public class EventService {

    public Event calculateDiscount(Order order) {
        boolean flag = false;

        if (order.getPrice() >= 10000) {
            flag = true;
        }

        int weekday = weekdayDiscount(order);
        int weekend = weekendDiscount(order);
        int christmas = christmasDiscount(order);
        int special = specialDiscount(order);

        return new Event(weekday, weekend, christmas, special, flag);
    }

    private int weekdayDiscount(Order order) {
        int date = order.getDate();
        int discount = 0;
        List<Integer> weekday = new ArrayList<>(
                List.of(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31));
        if (weekday.contains(date)) {
            for (String name : order.getMenu().keySet()) {
                Menu menu = Menu.fromName(name);
                if (menu.getCategory().equals("디저트")) {
                    discount += order.getMenu().get(name) * 2023;
                    order.addDiscount(order.getMenu().get(name) * 2023);
                }
            }
        }
        return discount;

    }

    private int weekendDiscount(Order order) {
        int date = order.getDate();
        int discount = 0;
        List<Integer> weekend = new ArrayList<>(
                List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)
        );

        if (weekend.contains(date)) {
            for (String name : order.getMenu().keySet()) {
                Menu menu = Menu.fromName(name);
                if (menu.getCategory().equals("메인")) {
                    discount += order.getMenu().get(name) * 2023;
                    order.addDiscount(order.getMenu().get(name) * 2023);
                }
            }
        }

        return discount;
    }

    private int christmasDiscount(Order order) {
        int date = order.getDate();
        int discount = 1000;
        if (date >= 1 && date <= 25) {
            discount += (date - 1) * 100;
            order.addDiscount(discount);
        }
        return discount;
    }

    private int specialDiscount(Order order) {
        int date = order.getDate();
        List<Integer> special = new ArrayList<>(
                List.of(3, 10, 17, 24, 25, 31)
        );
        if (special.contains(date)) {
            order.addDiscount(1000);
            return 1000;
        }
        return 0;
    }
}
