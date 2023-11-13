package christmas;

public class Badge {
    enum BadgeSort {
        없음(0),
        별(5000),
        트리(10000),
        산타(20000);

        private int discountedPrice;

        BadgeSort(int discountedPrice) {
            this.discountedPrice = discountedPrice;
        }
    }

    public BadgeSort getBedge(int discountedPrice) {
        BadgeSort presentation = BadgeSort.없음;
        for (BadgeSort badge : BadgeSort.values()) {
            if (badge.discountedPrice <= discountedPrice) {
                presentation = badge;
            }
        }
        return presentation;
    }
}
