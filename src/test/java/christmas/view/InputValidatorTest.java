package christmas.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    @DisplayName("잘못된 날짜 입력 검증")
    void validateDate() {
        checkBadDate("a");
        checkBadDate("123");
        checkBadDate("-1");

        checkGoodDate("09");
        checkGoodDate("9");
        checkGoodDate("99");
    }

    @Test
    @DisplayName("잘못된 주문 입력 검증")
    void validateOrders() {
        checkBadOrders(",,,");
        checkBadOrders("---");
        checkBadOrders("");
        checkBadOrders("바비큐립-1,");
        checkBadOrders(",바비큐립-1");
        checkBadOrders("바비큐립-1,바비큐립-1");

        checkGoodOrders("타파스-1,제로콜라-1");
        checkGoodOrders("타파스-1,제로콜라-1,바비큐립-10");
    }

    private static void checkBadDate(String input) {
        Assertions.assertThatThrownBy(() -> InputValidator.validateDate(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private static void checkGoodDate(String input) {
        Assertions.assertThatCode(() -> InputValidator.validateDate(input)).
            doesNotThrowAnyException();
    }

    private static void checkBadOrders(String input) {
        Assertions.assertThatThrownBy(() -> InputValidator.validateOrders(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    private static void checkGoodOrders(String input) {
        Assertions.assertThatCode(() -> InputValidator.validateOrders(input)).
            doesNotThrowAnyException();
    }
}