package christmas;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        int date = inputView.infiniteDateInputsUntilRight();
        Order order = inputView.infiniteOrderInputUntilRight();
        Map<Menu, Integer> orderMenu = order.getOrder();
        int fullPrice = order.sumAllOrderMenuPrice(orderMenu);
        DiscountEvent discountEvent = new DiscountEvent(orderMenu, date);
        Map<String, Integer> allDiscounts = discountEvent.validateAndGetAllDiscount(fullPrice);
        int sumBenefits = discountEvent.getAllDiscountPrice(allDiscounts);
        outputView.outOrder(orderMenu);
        outputView.outFullPrice(fullPrice);
        outputView.outAllAboutDiscount(allDiscounts);
        outputView.outSumBenefits(sumBenefits);
        outputView.outActualPayment(fullPrice, allDiscounts);
        outputView.outBadge(sumBenefits);
    }
}
