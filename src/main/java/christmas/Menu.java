package christmas;

import static christmas.Menu.Sort.*;

public enum Menu {
    양송이수프(에피타이저, 6_000),
    타파스(에피타이저, 5_500),
    시저샐러드(에피타이저, 8_000),
    티본스테이크(메인, 55_000),
    바비큐립(메인, 54_000),
    해산물파스타(메인, 35_000),
    크리스마스파스트(메인, 25_000),
    초코케이크(디저트, 15_000),
    아이스크림(디저트, 5_000),
    제로콜라(음료, 3_000),
    레드와인(음료, 60_000),
    샴페인(음료, 25_000);
    enum Sort{
        에피타이저, 메인, 디저트, 음료
    }
    private Sort sort;
    private int price;

    Menu(Sort sort, int price){
        this.sort = sort;
        this.price = price;
    }
}
