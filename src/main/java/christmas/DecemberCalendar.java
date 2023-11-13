package christmas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DecemberCalendar {
    enum Day {
        MONDAY(DiscountEvent.DayEvent.평일_할인, 4, 11, 18, 25),
        TUESDAY(DiscountEvent.DayEvent.평일_할인, 5, 12, 19, 26),
        WEDNSEDAY(DiscountEvent.DayEvent.평일_할인, 6, 13, 20, 27),
        THURSDAY(DiscountEvent.DayEvent.평일_할인, 7, 14, 21, 28),
        FRIDAY(DiscountEvent.DayEvent.주말_할인, 1, 8, 15, 22, 29),
        SATURDAY(DiscountEvent.DayEvent.주말_할인, 2, 9, 16, 23, 30),
        SUNDAY(null, 3, 10, 17, 24, 31);

        private DiscountEvent.DayEvent event;
        private List<Integer> dates;

        Day(DiscountEvent.DayEvent event, int... date) {
            this.event = event;
            this.dates = Arrays.stream(date).boxed().collect(Collectors.toList());
        }

        public List<Integer> getDates() {
            return dates;
        }

        public DiscountEvent.DayEvent getEvent() {
            return event;
        }
    }

    public Day findDay(int date) {
        return Arrays.stream(Day.values())
                .filter(Calendar -> Calendar.dates.contains(date))
                .findAny()
                .orElse(null);
    }
}
