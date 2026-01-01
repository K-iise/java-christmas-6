package christmas.controller;

import christmas.domain.Order;
import christmas.service.Parser;
import christmas.service.Separator;
import christmas.service.Validator;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.HashMap;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final Validator validator;

    public Controller(InputView inputView, OutputView outputView, Validator validator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = validator;
    }

    public void run(){
        // 방문 날짜 입력
        String date = loopDate();

        // 주문할 메뉴와 개수 입력
        String menu = loopMenu();

        Parser parser = new Parser();
        HashMap<String, Integer> menuMap = parser.splitMenu(menu);

        // 주문 정보 정리
        Order order = new Order(Integer.parseInt(date), menuMap);
    }

    public String loopDate(){
        while (true){
            try{
                String date = inputView.readDate();
                validator.validateDateNumber(date);
                return date;
            } catch (IllegalArgumentException e){
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public String loopMenu(){
        while (true){
            try{
                String menu = inputView.readMenu();
                validator.validateMenuFormat(menu);
                return menu;
            } catch (IllegalArgumentException e){
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
