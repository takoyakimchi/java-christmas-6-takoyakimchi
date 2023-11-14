package christmas.event.discount;

import christmas.event.Event;
import christmas.event.WeekendChecker;
import christmas.item.FoodType;
import christmas.order.Order;
import christmas.order.Orders;
import java.util.Optional;

public class WeekdayDiscount implements DiscountStrategy {

    @Override
    public Optional<Event> discount(Orders orders) {
        int discountPrice = 0;
        for (Order order : orders.getOrders()) {
            if (order.getItem().getType() == FoodType.DESSERT) {
                discountPrice += 2023 * order.getAmount();
            }
        }

        if (!WeekendChecker.isWeekend(orders.getOrderDate())) {
            return Optional.of(new Event("평일 할인", discountPrice, null));
        }
        return Optional.empty();
    }
}