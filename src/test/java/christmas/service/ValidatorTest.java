package christmas.service;

import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    public void 메뉴_이름_정상테스트(){
        Validator validator = new Validator();
        
        HashMap<String, Integer> menu = new HashMap<>();
        menu.put("양송이수프", 2);
        menu.put("타파스", 1);
        menu.put("시저샐러드", 1);
        Assertions.assertDoesNotThrow(() -> validator.validateMenuName(menu));
    }

    @Test
    public void 메뉴_이름_예외테스트(){
        Validator validator = new Validator();

        HashMap<String, Integer> menu = new HashMap<>();
        menu.put("양송이수프", 2);
        menu.put("해산물파스타", 1);
        menu.put("시저샐러드", 1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validateMenuName(menu));
        
    }
}
