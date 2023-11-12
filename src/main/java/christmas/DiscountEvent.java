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


}
