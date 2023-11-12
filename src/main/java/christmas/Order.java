package christmas;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Order {
    private Map<Menu, Integer> menuAndNumber;
    private boolean orderable;

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
    
}
