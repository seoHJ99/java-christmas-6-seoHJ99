package christmas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BadgeTest {

    private Badge badge;

    private final int EXPECTED_NONE =0;
    private final int EXPECTED_STAR =5000;
    private final int EXPECTED_TREE =10000;
    private final int EXPECTED_SANTA =20000;

    @BeforeEach
    void setup(){
        badge = new Badge();
    }

    @DisplayName("금액에 따라 맞는 배지를 찾는지 확인")
    @Test
    void findBadge() {
        assertThat(badge.findBadge(EXPECTED_NONE)).isEqualTo(Badge.BadgeSort.없음);
        assertThat(badge.findBadge(EXPECTED_STAR)).isEqualTo(Badge.BadgeSort.별);
        assertThat(badge.findBadge(EXPECTED_TREE)).isEqualTo(Badge.BadgeSort.트리);
        assertThat(badge.findBadge(EXPECTED_SANTA)).isEqualTo(Badge.BadgeSort.산타);
    }
}