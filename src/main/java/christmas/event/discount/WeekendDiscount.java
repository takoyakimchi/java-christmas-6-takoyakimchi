package christmas.event.discount;

import christmas.event.Event;
import christmas.event.WeekendChecker;
import christmas.item.FoodType;
import christmas.order.Order;
import christmas.order.Orders;
import java.util.Optional;

public class WeekendDiscount implements DiscountStrategy {

    @Override
    public Optional<Event> discount(Orders orders) {
        int discountPrice = 0;
        for (Order order : orders.getOrders()) {
            if (order.getItem().getType() == FoodType.MAIN) {
                discountPrice += 2023 * order.getAmount();
            }
        }

        if (WeekendChecker.isWeekend(orders.getOrderDate())) {
            return Optional.of(new Event("주말 할인", discountPrice, null));
        }
        return Optional.empty();
    }
}
