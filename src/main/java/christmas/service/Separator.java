package christmas.service;

import java.util.HashMap;

public class Separator {
    public HashMap<String, Integer> splitMenu(String menu){
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
}
