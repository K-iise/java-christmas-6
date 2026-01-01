package christmas.controller;

import christmas.domain.Order;
import christmas.service.Separator;
import christmas.service.Validator;
import christmas.view.InputView;
import java.util.HashMap;

public class Controller {

    private InputView inputView;
    private Validator validator;
    private Separator separator;

    public void run(){
        // 방문 날짜 입력
        String date = inputView.readDate();
        validator.validateDateNumber(date);

        // 주문할 메뉴와 개수 입력
        String menu = inputView.readMenu();
        HashMap<String, Integer> menuMap = separator.splitMenu(menu);
        validator.validateMenuName(menuMap);

        // 주문 정보 정리
        Order order = new Order(Integer.parseInt(date), menuMap);
    }
}
