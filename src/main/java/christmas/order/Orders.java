package christmas.order;

import christmas.item.Item;

public class Orders {

    private final OrderDate orderDate;
    private final OrderItemMap itemMap;

    public Orders(OrderDate orderDate, OrderItemMap itemMap) {
        this.orderDate = orderDate;
        this.itemMap = itemMap;
    }

    public int getOrderDate() {
        return orderDate.getDate();
    }

    public OrderItemMap getItemMap() {
        return itemMap;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Item item : itemMap.getKeySet()) {
            totalPrice += item.getPrice() * itemMap.getAmount(item);
        }
        return totalPrice;
    }
}