package christmas.event.discount;

import christmas.order.Orders;
import java.util.Optional;

public class DdayDiscount implements DiscountStrategy {

    @Override
    public Optional<DiscountEvent> discount(Orders orders) {
        int orderDate = orders.getOrderDate();
        if (orderDate >= 1 && orderDate <= 25) {
            int discountPrice = 1000 + (orderDate - 1) * 100;
            return Optional.of(new DiscountEvent("크리스마스 디데이 할인", discountPrice));
        }
        return Optional.empty();
    }
}
