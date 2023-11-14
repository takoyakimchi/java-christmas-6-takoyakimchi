package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.db.ItemRepository;
import christmas.item.Item;
import christmas.order.Order;
import christmas.order.Orders;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static Orders readDate() {
        while (true) {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
            try {
                String input = Console.readLine();
                int orderDate = toInt(input, "유효하지 않은 날짜입니다. 다시 입력해 주세요.");
                return new Orders(orderDate);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public static void readOrders(Orders orders) {
        while (true) {
            System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요."
                + "(e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
            try {
                String input = Console.readLine();
                orders.setOrders(toOrderList(input));
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static List<Order> toOrderList(String input) {
        List<Order> orderList = new ArrayList<>();
        for (String orderInput : input.split(",")) {
            String[] itemInput = orderInput.split("-");
            if (itemInput.length != 2) {
                throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
            Item item = ItemRepository.findByName(itemInput[0])
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
            int amount = toInt(itemInput[1], "유효하지 않은 주문입니다. 다시 입력해 주세요.");
            orderList.add(new Order(item, amount));
        }
        return orderList;
    }

    private static int toInt(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
