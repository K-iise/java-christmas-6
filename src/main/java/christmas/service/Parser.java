package christmas.service;

import christmas.domain.Menu;
import christmas.domain.Order;
import java.util.HashMap;
import javax.swing.ImageIcon;

public class Parser {

    public Order purchaseOrder(String date, String menu){
        int dt = Integer.parseInt(date);
        HashMap<String, Integer> menuMap = splitMenu(menu);
        int price = calculatePrice(menuMap);
        return new Order(dt, price, menuMap);
    }

    private HashMap<String, Integer> splitMenu(String menu){
        HashMap<String, Integer> map = new HashMap<>();

        String[] sp = menu.split(",");

        for (String main : sp) {
            String[] take = main.split("-");
            String name = take[0];
            String quantity = take[1];
            map.put(name, Integer.parseInt(quantity));
        }

        return map;
    }

    private int calculatePrice(HashMap<String, Integer> map){
        int result = 0;

        for (String name : map.keySet()){
            result += Menu.getPrice(name) * map.get(name);
        }
        return result;
    }
}
