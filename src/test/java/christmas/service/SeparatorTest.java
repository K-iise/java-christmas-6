package christmas.service;

import java.util.HashMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SeparatorTest {

    @Test
    public void 메뉴_형식_분리_테스트(){
        Separator separator = new Separator();
        String data = "해산물파스타-1,레드와인-2,초코케이크-1";
        String[] menu = separator.splitByComma(data);
        
        Assertions.assertThat(menu.length).isEqualTo(3);
    }

    @Test
    public void 메뉴_이름_분리_테스트(){
        Separator separator = new Separator();
        String data = "해산물파스타-2";
        String name = separator.splitByName(data);

        Assertions.assertThat(name).isEqualTo("해산물파스타");
    }

    @Test
    public void 메뉴_개수_분리_테스트(){
        Separator separator = new Separator();
        String data = "해산물파스타-2";
        String quantity = separator.splitByQuantity(data);

        Assertions.assertThat(quantity).isEqualTo("2");
    }

}
