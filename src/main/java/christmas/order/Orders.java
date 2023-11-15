package christmas.order;

import christmas.item.FoodType;
import christmas.item.Item;
import java.util.List;
import java.util.Map;

public class Orders {

    private final OrderDate orderDate;
    private final Map<Item, Integer> orders;

    public Orders(OrderDate orderDate, Map<Item, Integer> orders) {
        this.orderDate = orderDate;
        this.orders = orders;
    }

    public int getOrderDate() {
        return orderDate.getDate();
    }

    public Map<Item, Integer> getOrders() {
        return orders;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Item item : orders.keySet()) {
            totalPrice += item.getPrice() * orders.get(item);
        }
        return totalPrice;
    }

    private void validateOrders(List<Order> orders) {
        validateOrderCount(orders);
        validateBeverage(orders);
    }

    private void validateOrderCount(List<Order> orders) {
        int orderCount = 0;
        for (Order order : orders) {
            orderCount += order.getAmount();
        }
        if (orderCount > 20) {
            throw new IllegalArgumentException("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
        }
    }

    private void validateBeverage(List<Order> orders) {
        for (Order order : orders) {
            if (order.getItem().getType() != FoodType.BEVERAGE) {
                return;
            }
        }
        throw new IllegalArgumentException("음료만 주문 시, 주문할 수 없습니다.");
    }
}
