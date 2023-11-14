package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class DecemberCalendarTest {

    @DisplayName("날짜에 맞춰 맞는 요일을 찾는지 테스트")
    @Test
    void findDay() {
        DecemberCalendar calendar = new DecemberCalendar();
        assertThat(calendar.findDay(2)).isEqualTo(DecemberCalendar.Day.SATURDAY);
        assertThat(calendar.findDay(3)).isEqualTo(DecemberCalendar.Day.SUNDAY);
        assertThat(calendar.findDay(4)).isEqualTo(DecemberCalendar.Day.MONDAY);
        assertThat(calendar.findDay(5)).isEqualTo(DecemberCalendar.Day.TUESDAY);
        assertThat(calendar.findDay(6)).isEqualTo(DecemberCalendar.Day.WEDNSEDAY);
        assertThat(calendar.findDay(7)).isEqualTo(DecemberCalendar.Day.THURSDAY);
        assertThat(calendar.findDay(8)).isEqualTo(DecemberCalendar.Day.FRIDAY);
        assertThatThrownBy(() -> assertThat(calendar.findDay(8)).isEqualTo(DecemberCalendar.Day.SATURDAY));
    }
}