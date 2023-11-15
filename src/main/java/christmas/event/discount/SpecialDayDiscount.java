package christmas.event.discount;

import christmas.event.domain.DiscountEvent;
import christmas.order.Orders;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SpecialDayDiscount implements DiscountStrategy {

    @Override
    public Optional<DiscountEvent> discount(Orders orders) {
        List<Integer> specialDays = new ArrayList<>(List.of(3, 10, 17, 24, 25, 31));
        if (specialDays.contains(orders.getOrderDate())) {
            return Optional.of(new DiscountEvent("특별 할인", 1000));
        }
        return Optional.empty();
    }
}