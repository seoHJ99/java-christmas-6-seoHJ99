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
            System.out.println();
        }
    }

}
