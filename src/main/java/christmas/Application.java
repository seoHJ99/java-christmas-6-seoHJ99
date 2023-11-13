package christmas;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int date = inputView.readDate();
        List<String> orderString = inputView.readOrder();
        Order order = new Order();
        Map<Menu, Integer> orderMenu = order.classifyOrder(orderString);
        order.validateMenuSort(orderMenu);
        int fullPrice = order.sumAllOrderMenuPrice(orderMenu);
        DiscountEvent discountEvent = new DiscountEvent(orderMenu, date);
        discountEvent.validate(fullPrice);
        OutputView outputView = new OutputView();
        outputView.outOrder(orderMenu);
        int a = discountEvent.getSpecialDiscount();
        int b = discountEvent.getDiscountPerSort();
        int c = discountEvent.getChristmasDDayDiscount();
        int d = discountEvent.getChampagnePresentation(fullPrice);
        Badge badge = new Badge();
        Badge.BadgeSort badgeSort = badge.getBedge(a + b + c + d);
        Map<String, Integer> map = discountEvent.getAllDiscountsMap();
        outputView.outFullPrice(fullPrice);
        outputView.outPresentation(map);
        outputView.outBenefits(map);
        outputView.outSumBenefits(a + b + c + d);
        outputView.outActualPayment(fullPrice, map);
        outputView.outBadge(a + b + c + d);
    }
}
