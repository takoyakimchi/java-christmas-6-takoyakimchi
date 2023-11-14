package christmas.order;

import christmas.db.ItemData;
import christmas.item.FoodType;
import christmas.item.Item;
import java.util.List;

public class Orders {

    private final int orderDate;
    private List<Order> orders;

    public Orders(int orderDate) {
        validateOrderDate(orderDate);
        this.orderDate = orderDate;
    }

    public void setOrders(List<Order> orders) {
        validateOrders(orders);
        this.orders = orders;
    }

    public int getOrderDate() {
        return orderDate;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Order order : orders) {
            totalPrice += order.getItem().getPrice() * order.getAmount();
        }
        return totalPrice;
    }

    private void validateOrderDate(int orderDate) {
        if (orderDate < 1 || orderDate > 31) {
            throw new IllegalArgumentException("1에서 31까지의 숫자를 입력해 주세요.");
        }
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
