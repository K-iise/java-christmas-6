package christmas.service;

import christmas.domain.Menu;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Validator {

    private Separator separator;

    public void validateDateNumber(String date){
        try {
            int num = Integer.parseInt(date);

            if (!(num >= 1 && num <= 31)){
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public void validateMenuFormat(String input){
        String[] menus = separator.splitByComma(input);

        for (String menu : menus){
            validateSingleMenuName(menu);
        }

        validateDuplication(menus);
    }

    public void validateSingleMenuName(String menu){
        validateHyphenFormat(menu);
        validateMenuName(menu);
        validateMenuQuantity(menu);
    }

    private void validateHyphenFormat(String menu) {
        if (menu.split("-").length != 2) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateMenuName(String menu) {
        String menuName = separator.splitByName(menu);
        if (!Menu.exists(menuName)){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateMenuQuantity(String menu) {
        String menuQuantity = separator.splitByQuantity(menu);

        try {
            int quantity = Integer.parseInt(menuQuantity);

            if (quantity < 0){
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void validateDuplication(String[] menus){
        Set<String> menuName = new HashSet<>();
        for (String name : menus){
            menuName.add(name);
        }
        if (menuName.size() != menus.length){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }





}
