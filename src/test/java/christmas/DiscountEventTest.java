package christmas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DiscountEventTest {

    private DiscountEvent discountEvent;

    private final Menu MAIN = Menu.바비큐립;
    private final Menu DESSERT1 = Menu.아이스크림;
    private final Menu DESSERT2 = Menu.초코케이크;
    private final Menu BEVERAGE = Menu.제로콜라;
    private final int MENU_SORT_DISCOUNT_PRICE = 2023;
    private final int SPECIAL_DAY_DISCOUNT_PRICE = 1000;
    private final int WEEKDAY = 4;
    private final int SPECIAL_DAY = 3;
    private final int CHRISTMAS = 25;
    private final int WEEKEND = 2;

    @BeforeEach
    void setup() {

    }

    @DisplayName("날짜가 평일인지, 주말인지 판별해서 그에 맞는 할인 적용하는지 확인")
    @Test
    void getDiscountPerSort() {
        discountEvent = new DiscountEvent(Map.of(MAIN,1, BEVERAGE,2), WEEKEND);
        assertThat(discountEvent.getDiscountPerSort()).isEqualTo( MENU_SORT_DISCOUNT_PRICE);
        discountEvent = new DiscountEvent(Map.of(MAIN,1, DESSERT1, 2), WEEKDAY);
        assertThat(discountEvent.getDiscountPerSort()).isEqualTo( MENU_SORT_DISCOUNT_PRICE * 2);
        discountEvent = new DiscountEvent(Map.of(MAIN,1, DESSERT2,1), SPECIAL_DAY);
        assertThat(discountEvent.getDiscountPerSort()).isEqualTo(MENU_SORT_DISCOUNT_PRICE);
    }

    @DisplayName("크리스마스 디데이 할인 금액을 구하는 함수 테스트")
    @Test
    void getChristmasDDayDiscount() {
        discountEvent = new DiscountEvent(Map.of(MAIN,1, BEVERAGE,2), CHRISTMAS);
        assertThat(discountEvent.getChristmasDDayDiscount()).isEqualTo(3400);
        discountEvent = new DiscountEvent(Map.of(MAIN,1, BEVERAGE,2), 26);
        assertThat(discountEvent.getChristmasDDayDiscount()).isEqualTo(0);
    }

    @DisplayName("25일이나 일요일에 특별 할인이 적용되는지 테스트")
    @Test
    void getSpecialDiscount() {
        discountEvent = new DiscountEvent(Map.of(MAIN,1, BEVERAGE,2), CHRISTMAS);
        assertThat(discountEvent.getSpecialDiscount()).isEqualTo(SPECIAL_DAY_DISCOUNT_PRICE);
        discountEvent = new DiscountEvent(Map.of(MAIN,1, BEVERAGE,2), SPECIAL_DAY);
        assertThat(discountEvent.getSpecialDiscount()).isEqualTo(SPECIAL_DAY_DISCOUNT_PRICE);
        discountEvent = new DiscountEvent(Map.of(MAIN,1, BEVERAGE,2), WEEKEND);
        assertThat(discountEvent.getSpecialDiscount()).isEqualTo(0);
    }

    @DisplayName("12만원 이상 구매시 샴페인 가격만큼 혜택금액이 추가되는지 테스트")
    @Test
    void getChampagnePresentation() {
        discountEvent = new DiscountEvent(Map.of(MAIN,1, BEVERAGE,2), CHRISTMAS);
        assertThat(discountEvent.getChampagnePresentation(5000)).isEqualTo(0);
        assertThat(discountEvent.getChampagnePresentation(120_000)).isEqualTo(Menu.샴페인.getPrice());
    }

    @DisplayName("1000원 이상일때만 할인해주는지 확인")
    @Test
    void validate() {
        discountEvent = new DiscountEvent(Map.of( BEVERAGE,2), CHRISTMAS);
        assertThat(discountEvent.validateDiscountTarget(6000)).isEqualTo(false);
        assertThat(discountEvent.validateDiscountTarget(10000)).isEqualTo(true);
    }
}