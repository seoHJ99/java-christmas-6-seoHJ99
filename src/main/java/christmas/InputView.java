package christmas;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public int readDate() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다. \n12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        validateDate(input);
        return Integer.parseInt(input);
    }

    public List<String> readOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine();
        List<String> order = new ArrayList<>(Arrays.asList(input.split(",")));
        System.out.println();
        return order;
    }

    private void validateDate(String date) {
        if (!date.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        int dateInt = Integer.parseInt(date);
        if (dateInt < 1 || dateInt > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public int infiniteDateInputsUntilRight() {
        int date = 0;
        while (true) {
            try {
                date = readDate();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
        return date;
    }

    public Order infiniteOrderInputUntilRight() {
        Order order;
        while (true) {
            try {
                List<String> orderInput = readOrder();
                order = new Order(orderInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return order;
    }
}
