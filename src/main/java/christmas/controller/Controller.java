package christmas.controller;

import christmas.domain.Order;
import christmas.service.Parser;
import christmas.service.Separator;
import christmas.service.Validator;
import christmas.view.InputView;
import java.util.HashMap;

public class Controller {

    private final InputView inputView;
    private final Validator validator;
    private final Separator separator;

    public Controller(InputView inputView, Validator validator, Separator separator) {
        this.inputView = inputView;
        this.validator = validator;
        this.separator = separator;
    }

    public void run(){
        // 방문 날짜 입력
        String date = inputView.readDate();
        validator.validateDateNumber(date);

        // 주문할 메뉴와 개수 입력
        String menu = inputView.readMenu();
        Parser parser = new Parser();
        HashMap<String, Integer> menuMap = parser.splitMenu(menu);
        validator.validateMenuName(menuMap);

        // 주문 정보 정리
        Order order = new Order(Integer.parseInt(date), menuMap);
    }
}
