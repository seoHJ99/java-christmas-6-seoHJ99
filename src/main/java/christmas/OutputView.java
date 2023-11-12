package christmas;

import java.util.Iterator;
import java.util.Map;

public class OutputView {

    public void outOrder(Map<Menu, Integer> order){
        System.out.println("<주문메뉴>");
        Iterator<Menu> orderMenu = order.keySet().iterator();
        while (orderMenu.hasNext()){
            Menu menu = orderMenu.next();
            System.out.println(menu.name() + order.get(menu) + "개");
        }
    }

    public void outPresentation(int champagneCount){
        System.out.println("<증정 메뉴>");
        if(champagneCount>0){
            System.out.println("샴페인 " + champagneCount + "개");
        }
        System.out.println("없음");
    }

    public void outBenefits(Map<String, Integer> discounts){
        System.out.println("<혜택 내역>");
        Iterator<String> discountName = discounts.keySet().iterator();
        while (discountName.hasNext()){
            String name = discountName.next();
            int discountedPrice = discounts.get(name);
            System.out.println(name + ":" + "-" + discountedPrice);
        }
        if(discounts.size() == 0){
            System.out.println("없음");
        }
    }

    public void outSumBenefits(Map<String, Integer> discounts){
        Iterator<String> discountName = discounts.keySet().iterator();
        int sumBenefits = 0;
        while (discountName.hasNext()){
            String name = discountName.next();
            int discountedPrice = discounts.get(name);
            sumBenefits += discountedPrice;
        }
        System.out.println("<총 혜택 금액>");
        System.out.println(sumBenefits + "원");
    }

    public void outActualPayment(int fullPrice, Map<String, Integer> discounts){
        Iterator<String> discountName = discounts.keySet().iterator();
        int sumDiscountedPrice = 0;
        while (discountName.hasNext()){
            String name = discountName.next();
            if(!name.equals("증정 이벤트")){
                int discountedPrice = discounts.get(name);
                sumDiscountedPrice += discountedPrice;
            }
        }
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(fullPrice - sumDiscountedPrice);
    }

    public void outBadge(int sumBenefits){
        Badge badge = new Badge();
        Badge.BadgeSort badgeSort = badge.getBedge(sumBenefits);
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badgeSort.name());
    }
}
