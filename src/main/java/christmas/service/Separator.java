package christmas.service;

import java.util.HashMap;
import java.util.List;

public class Separator {

    public String[] splitByComma(String input){
        return input.split(",");
    }

    public String splitByQuantity(String input){
        String[] menu = input.split("-");
        return menu[1];
    }

    public String splitByName(String input){
        String[] menu = input.split("-");
        return menu[0];
    }
}
