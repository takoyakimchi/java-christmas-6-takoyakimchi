package christmas.order;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderDateTest {

    @Test
    @DisplayName("비정상 날짜 입력 시 예외 발생")
    void inputBadDate() {
        assertThatThrownBy(() -> new OrderDate(-1))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new OrderDate(0))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new OrderDate(32))
            .isInstanceOf(IllegalArgumentException.class);
    }
}