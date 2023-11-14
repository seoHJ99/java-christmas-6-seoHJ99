package christmas;

import java.util.*;
import java.util.function.Supplier;

public class DiscountEvent {

    enum DayEvent {
        평일_할인(() -> getWeekdayDiscountPrice()),

        주말_할인(() -> getWeekendDiscountPrice());

        private Supplier<Integer> discountCalculator;

        DayEvent(Supplier<Integer> discountCalculator) {
            this.discountCalculator = discountCalculator;
        }

        public int getWeekDiscount() {
            return discountCalculator.get();
        }
    }

    public boolean eventTarget = false;
    private Map<String, Integer> allDiscounts = Map.of("크리스마스 디데이 할인",0,"평일 할인",0,"주말 할인",0,"특별 할인",0,"증정 이벤트",0);
    private static Map<Menu, Integer> orderMenu;
    private static int date;
    private final int SPECIAL_DISCOUNT_AMOUNT = 1000;
    private static final int WEEK_DISCOUNT_PRICE = 2023;

    public DiscountEvent(Map<Menu, Integer> orderMenu, int date) {
        this.orderMenu = orderMenu;
        this.date = date;
    }

    public void validate(int fullPrice) {
        if (fullPrice >= 1_0000) {
            eventTarget = true;
        }
    }

    public int

    public int getDiscountPerSort() {
        DecemberCalendar.Day day = new DecemberCalendar().findDay(date);
        DayEvent event = Arrays.stream(DayEvent.values())
                .filter(value -> day.getEvent().equals(value))
                .findAny()
                .orElse(null);
        allDiscounts.put(event.name().replace("_"," "), event.getWeekDiscount());
        return event.getWeekDiscount();
    }

    public static int getWeekdayDiscountPrice() {
        int targetMenuSort = 0;
        Iterator<Menu> menus = orderMenu.keySet().iterator();
        while (menus.hasNext()) {
            Menu name = menus.next();
            Menu.Sort sort = name.getSort();
            if (sort == Menu.Sort.디저트) {
                targetMenuSort += orderMenu.get(name);
            }
        }
        return targetMenuSort * WEEK_DISCOUNT_PRICE;
    }

    public static int getWeekendDiscountPrice() {
        int targetMenuSort = 0;
        Iterator<Menu> menus = orderMenu.keySet().iterator();
        while (menus.hasNext()) {
            Menu name = menus.next();
            Menu.Sort sort = name.getSort();
            if (sort == Menu.Sort.메인) {
                targetMenuSort += orderMenu.get(name);
            }
        }
        return targetMenuSort * WEEK_DISCOUNT_PRICE;
    }

    public int getChristmasDDayDiscount() {
        if (date <= 25) {
            allDiscounts.put("크리스마스 디데이 할인", (date - 1) * 100 + 1000);
            return (date - 1) * 100 + 1000;
        }
        return 0;
    }

    public int getSpecialDiscount() {
        if (date == 25 || DecemberCalendar.Day.SUNDAY.getDates().contains(date)) {
            allDiscounts.put("특별 할인", SPECIAL_DISCOUNT_AMOUNT);
            return SPECIAL_DISCOUNT_AMOUNT;
        }
        return 0;
    }

    public int getChampagnePresentation(int fullPrice) {
        if (fullPrice >= 120_000) {
            allDiscounts.put("증정 이벤트", 25000);
            return Menu.샴페인.getPrice();
        }
        return 0;
    }

    public Map<String, Integer> getAllDiscountsMap(int fullPrice) {
        allDiscounts.clear();
        getSpecialDiscount();
        getDiscountPerSort();
        getChristmasDDayDiscount();
        getChampagnePresentation(fullPrice);
        return allDiscounts;
    }

    public int getAllDiscountPrice(Map<String, Integer> discounts){
        int sumDiscountedPrice = 0;
        Iterator<String> discountName = discounts.keySet().iterator();
        while (discountName.hasNext()) {
            String name = discountName.next();
            int discountedPrice = discounts.get(name);
            sumDiscountedPrice += discountedPrice;
        }
        return sumDiscountedPrice;
    }
}