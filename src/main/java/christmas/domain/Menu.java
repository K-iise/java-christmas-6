package christmas.domain;

import java.util.Arrays;
import javax.swing.DefaultListSelectionModel;

public enum Menu {
    양송이수프("애피타이저", 6000),
    타파스("애피타이저", 5500),
    시저샐러드("애피타이저",8000),
    MISS(null, 0);

    private final String category;
    private final int price;

    Menu(String category, int price) {
        this.category = category;
        this.price = price;
    }

    public static boolean exists(String menuName){
        for (Menu menu : Menu.values()){
            if (menu.name().equals(menuName))
                return true;
        }
        return false;
    }
}
