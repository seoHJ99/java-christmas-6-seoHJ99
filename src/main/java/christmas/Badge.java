package christmas;

import java.util.Arrays;

public enum Badge {
    별(5000),
    트리(10000),
    산타(20000);

    private int discountedPrice;

    Badge(int discountedPrice){
        this.discountedPrice = discountedPrice;
    }

    public Badge getBedge(int discountedPrice){
        Badge presentation = null;
        for(Badge badge : Badge.values()){
            if(badge.discountedPrice >= discountedPrice){
                presentation = badge; 
            }
        }
        return presentation;
    }
}
