package christmas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;

    @BeforeEach
    void setup(){
        order = new Order(List.of("양송이수프-1", "레드와인-2"));
    }

    @DisplayName("중복시 예외가 발생하는지 확인")
    @Test
    void validateDuplication() {
        assertThatThrownBy(() ->
                order.validateDuplication(
                        Map.of(Menu.바비큐립, 1, Menu.양송이수프, 2, Menu.레드와인, 3), Menu.바비큐립)
        )
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> order = new Order(List.of("양송이수프-1", "양송이수프-2")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료만 주문할때 오류 발생하는지 확인")
    @Test
    void validateMenuSort() {
        assertThatThrownBy(() -> order.validateMenuSort(Map.of(Menu.샴페인,1,Menu.제로콜라,2,Menu.레드와인,3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("존재하지 않는 메뉴를 입력시 예외 발생하는지 테스트")
    @Test
    void validateMenuName() {
        List<String> menuName = List.of("짬뽕", "짜장면", "탕수육");
        for(String name : menuName){
            Menu menu = Arrays.stream(Menu.values())
                    .filter((value)->value.name().equals(name))
                    .findAny()
                    .orElse(null);
            assertThatThrownBy(()->order.validateMenuName(menu))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("입력된 메뉴 형식이 옳은지 확인")
    @Test
    void validateMenuForm() {
        assertThatThrownBy(() -> order.validateMenuForm(List.of("바비큐립 - 2", "비비빅-1")))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatCode(()->order.validateMenuForm(List.of("바비큐립-2", "레드와인-1", "초코케이크-3")))
                .doesNotThrowAnyException();
    }

    @Test
    void sumAllOrderMenuPrice() {
        assertThat(order.sumAllOrderMenuPrice(Map.of(Menu.샴페인,1,Menu.양송이수프,2,Menu.크리스마스파스트,2)))
                .isEqualTo(Menu.샴페인.getPrice()
                +Menu.양송이수프.getPrice()*2
                + Menu.크리스마스파스트.getPrice()*2);
    }
}