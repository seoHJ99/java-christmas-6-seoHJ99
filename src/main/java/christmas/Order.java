package christmas;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Order {
    private Map<Menu, Integer> menuAndNumber;
    private boolean orderable;
    private int fullPrice;

    public Map<Menu, Integer> classifyOrder (List<String> order){
        for(String nameAndNumber : order){
            String name = nameAndNumber.split("-")[0];
            int number = Integer.parseInt(nameAndNumber.split("-")[1]);
            Menu menu =   Arrays.stream(Menu.values())
                    .filter(Menu -> Menu.name().equals(name))
                    .findAny()
                    .orElse(null);
            menuAndNumber.put(menu, number);
        }
        return menuAndNumber;
    }

    public boolean validateMenuSort(Map<Menu, Integer> order){
        Iterator<Menu> menus = order.keySet().iterator();
        boolean onlyBeverage = true;
        while (menus.hasNext()) {
            Menu.Sort sort = menus.next().getSort();
            if(sort != Menu.Sort.음료){
                onlyBeverage = false;
                break;
            }
        }
        if(onlyBeverage == false){
            orderable = true;
            return orderable;
        }
        return orderable;
    }

    public int sumAllOrderMenuPrice(Map<Menu, Integer> order){
        Iterator<Menu> menus = order.keySet().iterator();
        while (menus.hasNext()) {
            Menu menu = menus.next();
            fullPrice += menu.getPrice();
        }
        return fullPrice;
    }
}
