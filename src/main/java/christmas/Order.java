package christmas;

import java.util.*;

public class Order {
    private Map<Menu, Integer> menuAndNumber = new HashMap<>();
    private int fullPrice;

    public Map<Menu, Integer> classifyOrder (List<String> order){
        validateMenuForm(order);
        for(String nameAndNumber : order){
            String name = nameAndNumber.split("-")[0];
            int number = Integer.parseInt(nameAndNumber.split("-")[1]);
            Menu menu =   Arrays.stream(Menu.values())
                    .filter(Menu -> Menu.name().equals(name))
                    .findAny()
                    .orElse(null);
            validateMenuName(menu);
            validateDuplication(menuAndNumber, menu);
            menuAndNumber.put(menu, number);
        }
        return menuAndNumber;
    }

    public void validateDuplication(Map<Menu, Integer> order, Menu menu){
        if(order.containsKey(menu)){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void validateMenuSort(Map<Menu, Integer> order){
        Iterator<Menu> menus = order.keySet().iterator();
        boolean onlyBeverage = true;
        while (menus.hasNext()) {
            Menu.Sort sort = menus.next().getSort();
            if(sort != Menu.Sort.음료){
                onlyBeverage = false;
                break;
            }
        }
        if(onlyBeverage == true){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void validateMenuName(Menu menu){
        if(menu == null){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void validateMenuForm(List<String> order){
        for(String oneMenu : order){
            if(!oneMenu.contains("-")){
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
            String[] splitOrder = oneMenu.split("-");
            if(splitOrder[0].matches(".*[0-9!@#$%^&*()_+\\-=\\[\\]{};':\",.<>?].*")){
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
            if(!splitOrder[1].matches("[0-9]+")){
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    public int sumAllOrderMenuPrice(Map<Menu, Integer> order){
        Iterator<Menu> menus = order.keySet().iterator();
        while (menus.hasNext()) {
            Menu menu = menus.next();
            fullPrice += menu.getPrice() * order.get(menu);
        }
        return fullPrice;
    }
}
