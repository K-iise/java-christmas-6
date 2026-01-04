package christmas.service;

import christmas.domain.Order;

public interface DiscountPolicy {
    int calculate(Order order);
}
