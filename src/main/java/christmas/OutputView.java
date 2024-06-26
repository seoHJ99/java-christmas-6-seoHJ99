package christmas;

import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Map;

public class OutputView {

    private NumberFormat numberFormat = NumberFormat.getInstance();

    public void outOrder(Map<Menu, Integer> order) {
        System.out.println("<주문 메뉴>");
        Iterator<Menu> orderMenu = order.keySet().iterator();
        while (orderMenu.hasNext()) {
            Menu menu = orderMenu.next();
            System.out.println(menu.name() + order.get(menu) + "개");
        }
        System.out.println();
    }

    public void outFullPrice(int fullPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(numberFormat.format(fullPrice) + "\n");
    }

    public void outPresentation(Map<String, Integer> benefits) {
        System.out.println("<증정 메뉴>");
        if (benefits.get("증정 이벤트")!= null && benefits.get("증정 이벤트") != 0 ) {
            System.out.println("샴페인 1개\n");
            return;
        }
        System.out.println("없음\n");
    }

    public void outBenefits(Map<String, Integer> discounts) {
        System.out.println("<혜택 내역>");
        Iterator<String> discountName = discounts.keySet().iterator();
        boolean hasBenefit = false;
        while (discountName.hasNext()) {
            String name = discountName.next();
            int discountedPrice = discounts.get(name);
            if (discountedPrice != 0) {
                hasBenefit = true;
                System.out.println(name + ":" + "-" + numberFormat.format(discountedPrice) );
            }
        }
        if (hasBenefit == false) {
            System.out.println("없음\n");
        }
    }

    public void outSumBenefits(int sumBenefits) {
        System.out.println("<총혜택 금액>");
        if(sumBenefits >0){
            System.out.print("-");
        }
        System.out.println( numberFormat.format(sumBenefits) + "원\n");
    }

    public void outActualPayment(int fullPrice, Map<String, Integer> discounts) {
        Iterator<String> discountName = discounts.keySet().iterator();
        int sumDiscountedPrice = 0;
        while (discountName.hasNext()) {
            String name = discountName.next();
            if (!name.equals("증정 이벤트")) {
                int discountedPrice = discounts.get(name);
                sumDiscountedPrice += discountedPrice;
            }
        }
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(numberFormat.format(fullPrice - sumDiscountedPrice) + "\n");
    }

    public void outBadge(int sumBenefits) {
        Badge badge = new Badge();
        Badge.BadgeSort badgeSort = badge.findBadge(sumBenefits);
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badgeSort.name() + "\n");
    }

    public void outAllAboutDiscount(Map<String, Integer> allDiscounts) {
        outPresentation(allDiscounts);
        outBenefits(allDiscounts);
    }
}
