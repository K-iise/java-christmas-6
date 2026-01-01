package christmas;

import christmas.controller.Controller;
import christmas.service.Separator;
import christmas.service.Validator;
import christmas.view.InputView;
import christmas.view.OutputView;
import javax.swing.InputMap;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Separator separator = new Separator();
        Validator validator = new Validator(separator);

        Controller controller = new Controller(inputView, outputView, validator);
        controller.run();
    }
}
