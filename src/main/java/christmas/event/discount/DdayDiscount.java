package christmas.event.discount;

import christmas.event.Event;
import christmas.order.Orders;
import java.util.Optional;

public class DdayDiscount implements DiscountStrategy {

    @Override
    public Optional<Event> discount(Orders orders) {
        int orderDate = orders.getOrderDate();
        if (orderDate >= 1 && orderDate <= 25) {
            int discountPrice = 1000 + (orderDate - 1) * 100;
            return Optional.of(new Event("크리스마스 디데이 할인", discountPrice, null));
        }
        return Optional.empty();
    }
}
