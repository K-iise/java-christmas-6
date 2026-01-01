package christmas.controller;

import christmas.domain.Event;
import christmas.domain.Order;
import christmas.service.EventService;
import christmas.service.Parser;
import christmas.service.Validator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final Validator validator;

    public Controller(InputView inputView, OutputView outputView, Validator validator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = validator;
    }

    public void run() {
        // 방문 날짜 입력
        String date = loopDate();

        // 주문할 메뉴와 개수 입력
        String menu = loopMenu();

        // 이벤트 참여
        Parser parser = new Parser();
        Order order = parser.purchaseOrder(date, menu);

        // 주문 메뉴 출력
        outputView.printMenuOrder(order);

        // 증정 메뉴
        outputView.printGift(order);

        // 총 할인 내역
        EventService service = new EventService();
        Event event = service.calculateDiscount(order);
        outputView.printDiscount(event, order);

        // 총 혜택 금액
        int discount = outputView.printAllDiscount(order);

        // 할인 후 예상 결제 금액
        outputView.printPrice(order);

        // 12월 이벤트 배지
        outputView.printBadge(discount);
    }

    public String loopDate() {
        while (true) {
            try {
                String date = inputView.readDate();
                validator.validateDateNumber(date);
                return date;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public String loopMenu() {
        while (true) {
            try {
                String menu = inputView.readMenu();
                validator.validateMenuFormat(menu);
                return menu;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
