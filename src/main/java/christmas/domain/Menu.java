package christmas.domain;

import java.util.Arrays;

public enum Menu {
    MUSHROOM_SOUP("양송이수프", "애피타이저", 6000),
    TAPAS("타파스", "애피타이저", 5500),
    CAESAR_SALAD("시저샐러드", "애피타이저", 8000),
    T_BONE_STEAK("티본스테이크", "메인", 55000),
    RIB("바비큐립", "메인", 54000),
    SEAFOOD_PASTA("해산물파스타", "메인", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", "메인", 25000),
    CHOCOLATE_CAKE("초코케이크", "디저트", 15000),
    ICE_CREAM("아이스크림", "디저트", 5000),
    ZERO_COKE("제로콜라", "음료", 3000),
    RED_WINE("레드와인", "음료", 60000),
    CHAMPAGNE("샴페인", "음료", 25000);

    private final String name;
    private final String category;
    private final int price;

    Menu(String name, String category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // 해당 메뉴의 이름이 존재하는지에 대핸 결과값을 반환
    public static boolean exists(String menuName) {
        return Arrays.stream(values())
                .anyMatch(menu -> menu.name.equals(menuName));
    }

    public static Menu fromName(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.name.equals(menuName)) {
                return menu;
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다.");
    }

    // 해당 메뉴에 대한 가격값을 반환.
    public int getPrice() {
        return price;
    }

    // 해당 메뉴의 카테고리를 반환.
    public String getCategory() {
        return category;
    }
}
