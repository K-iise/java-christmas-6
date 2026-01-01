package christmas;

import christmas.controller.Controller;
import christmas.service.Separator;
import christmas.service.Validator;
import christmas.view.InputView;
import javax.swing.InputMap;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        Validator validator = new Validator();
        Separator separator = new Separator();

        Controller controller = new Controller(inputView, validator, separator);

        controller.run();
    }
}
