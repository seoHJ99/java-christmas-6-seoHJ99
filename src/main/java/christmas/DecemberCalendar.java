package christmas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DecemberCalendar {
    enum Day {
        MONDAY(4, 11, 18, 25),
        TUESDAY(5, 12, 19, 26),
        WEDNSEDAY(6, 13, 20, 27),
        THURSDAY(7, 14, 21, 28),
        FRIDAY(1, 8, 15, 22, 29),
        SATURDAY(2, 9, 16, 23, 30),
        SUNDAY(3, 10, 17, 24, 31);

        private List<Integer> dates;
        private int date;

        Day(int... date) {
            this.dates = Arrays.stream(date).boxed().collect(Collectors.toList());
        }

    }
    public Day findDay(int date) {
        return Arrays.stream(Day.values())
                .filter(Calendar -> Calendar.dates.contains(date))
                .findAny()
                .orElse(null);
    }
}
