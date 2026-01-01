package christmas.service;

import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SeparatorTest {

    @Test
    public void 메뉴_분리_테스트(){
        Separator seperator = new Separator();
        HashMap<String, Integer> fake = new HashMap<>();
        fake.put("해산물파스타", 2);
        fake.put("레드와인", 1);
        fake.put("초코케이크", 1);

        HashMap<String, Integer> map = seperator.splitMenu("해산물파스타-2,레드와인-1,초코케이크-1");
        Assertions.assertEquals(map, fake);
    }

}
