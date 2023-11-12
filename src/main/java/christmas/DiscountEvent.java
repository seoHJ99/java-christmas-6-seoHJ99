package christmas;

import java.util.Iterator;
import java.util.Map;

public class DiscountEvent {

    public boolean eventTarget = false;
    private int christmasDiscountPrice = 0;
    private int specialDiscountPrice = 0;
    private boolean champagnePresentation = false;

    private final int discountPrice = 2023;

    public void validate(int fullPrice) {
        if (fullPrice < 10000) {
            eventTarget = true;
        }
    }

    public int getWeekdayDiscountPrice(Map<Menu, Integer> menuAndNumber) {
        int targetMenuSort = 0;
        Iterator<Menu> menus = menuAndNumber.keySet().iterator();
        while (menus.hasNext()) {
            Menu.Sort sort = menus.next().getSort();
            if (sort == Menu.Sort.디저트) {
                targetMenuSort++;
            }
        }
        return targetMenuSort * discountPrice;
    }

    public int getWeekendDiscountPrice(Map<Menu, Integer> menuAndNumber) {
        int targetMenuSort = 0;
        Iterator<Menu> menus = menuAndNumber.keySet().iterator();
        while (menus.hasNext()) {
            Menu.Sort sort = menus.next().getSort();
            if (sort == Menu.Sort.메인) {
                targetMenuSort++;
            }
        }
        return targetMenuSort * discountPrice;
    }

}
