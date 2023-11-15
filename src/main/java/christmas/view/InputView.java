package christmas.view;

import static christmas.event.EventConst.EVENT_MONTH;

import camp.nextstep.edu.missionutils.Console;
import christmas.db.ItemRepository;
import christmas.item.Item;
import christmas.order.OrderDate;
import christmas.order.OrderItemMap;
import java.util.HashMap;
import java.util.Map;

public class InputView {

    public static OrderDate readDate() {
        System.out.println(EVENT_MONTH + "월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        InputValidator.validateDate(input);
        return new OrderDate(Integer.parseInt(input));
    }

    public static OrderItemMap readOrders() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine();
        InputValidator.validateOrders(input);
        return new OrderItemMap(convertToMap(input));
    }

    private static Map<Item, Integer> convertToMap(String input) {
        Map<Item, Integer> orderMap = new HashMap<>();
        for (String orderString : input.split(",")) {
            String foodName = orderString.split("-")[0];
            Item item = ItemRepository.findByName(foodName)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요."));
            int amount = Integer.parseInt(orderString.split("-")[1]);
            orderMap.put(item, amount);
        }
        return orderMap;
    }
}