package christmas.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

    public static void validateDate(String input) {
        if (!Pattern.matches("[0-9]{1,2}", input)) {
            throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateOrders(String input) {
        validateOrdersInputForm(input);
        validateOrdersDuplication(input);
    }

    private static void validateOrdersInputForm(String input) {
        if (!Pattern.matches("^([a-zA-Z가-힣]+-\\d+)(,[a-zA-Z가-힣]+-\\d+)*$", input)) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void validateOrdersDuplication(String input) {
        List<String> foodNames = new ArrayList<>();

        for (String orderString : input.split(",")) {
            System.out.println("orderString = " + orderString);
            foodNames.add(orderString.split("-")[0]);
        }

        if (new HashSet<>(foodNames).size() != foodNames.size()) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
