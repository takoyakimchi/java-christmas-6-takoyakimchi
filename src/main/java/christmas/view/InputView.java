package christmas.view;

import static christmas.event.EventConst.EVENT_MONTH;

import camp.nextstep.edu.missionutils.Console;
import christmas.db.ItemRepository;
import christmas.item.Item;
import christmas.order.OrderItemMap;
import christmas.order.OrderDate;
import java.util.HashMap;
import java.util.Map;

public class InputView {

    public static OrderDate readDate() {
        while (true) {
            System.out.println(EVENT_MONTH + "월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
            try {
                String input = Console.readLine();
                return new OrderDate(
                    convertToInt(input, "유효하지 않은 날짜입니다. 다시 입력해 주세요."));
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public static OrderItemMap readOrders() {
        while (true) {
            System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요."
                + "(e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
            try {
                String input = Console.readLine();
                return new OrderItemMap(convertToMap(input));
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static Map<Item, Integer> convertToMap(String input) {
        Map<Item, Integer> orderMap = new HashMap<>();
        for (String orderInput : input.split(",")) {
            String[] itemInput = orderInput.split("-");
            if (itemInput.length != 2) {
                throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
            Item item = ItemRepository.findByName(itemInput[0])
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요."));
            int amount = convertToInt(itemInput[1], "유효하지 않은 주문입니다. 다시 입력해 주세요.");
            orderMap.put(item, amount);
        }
        return orderMap;
    }

    private static int convertToInt(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}