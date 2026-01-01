package christmas.view;

import christmas.domain.Event;
import christmas.domain.Order;
import java.text.DecimalFormat;
import java.util.HashMap;

public class OutputView {

    private DecimalFormat df = new DecimalFormat("###,###원");

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printMenuOrder(Order order) {
        System.out.println("12월 " + order.getDate() + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
        System.out.println("<주문 메뉴>");

        HashMap<String, Integer> menu = order.getMenu();

        for (String menuName : menu.keySet()) {
            System.out.println(menuName + " " + menu.get(menuName) + "개");
        }

        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(df.format(order.getPrice()));
    }

    public void printGift(Order order) {
        System.out.println("\n<증정 메뉴>");
        if (order.getPrice() >= 120000) {
            System.out.println("샴페인 1개");
            return;
        }

        System.out.println("없음");
    }

    public void printDiscount(Event event, Order order) {
        System.out.println("\n<혜택 내역>");

        if (!event.isFlag()) {
            System.out.println("없음");
            return;
        }

        if (event.getChristmasDiscount() != 0) {
            System.out.println("크리스마스 디데이 할인: -" + df.format(event.getChristmasDiscount()));
        }

        if (event.getWeekdayDiscount() != 0) {
            System.out.println("평일 할인: -" + df.format(event.getWeekdayDiscount()));
        }

        if (event.getWeekendDiscount() != 0) {
            System.out.println("주말 할인: -" + df.format(event.getWeekendDiscount()));
        }

        if (event.getSpecialDiscount() != 0) {
            System.out.println("특별 할인: -" + df.format(event.getSpecialDiscount()));
        }

        if (order.getPrice() >= 120000) {
            System.out.println("증정 이벤트 -" + df.format(25000));
        }
    }

    public int printAllDiscount(Order order) {
        System.out.println("\n<총혜택 금액>");
        int discount = order.getDiscount();
        if (order.getPrice() >= 120000) {
            discount += 25000;
        }
        if (discount > 0) {
            System.out.print("-");
        }
        System.out.println(df.format(discount));

        return discount;
    }

    public void printPrice(Order order) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(df.format(order.getPrice() - order.getDiscount()));
    }

    public void printBadge(int discount) {
        System.out.println("\n<12월 이벤트 배지>");
        if (discount >= 20000) {
            System.out.println("산타");
            return;
        }
        if (discount >= 10000) {
            System.out.println("트리");
            return;
        }
        if (discount >= 5000) {
            System.out.println("별");
            return;
        }

        System.out.println("없음");
    }

}
