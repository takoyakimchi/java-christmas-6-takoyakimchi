package christmas.event.discount;

import christmas.event.CalendarChecker;
import christmas.event.domain.DiscountEvent;
import christmas.item.FoodType;
import christmas.item.Item;
import christmas.order.Order;
import christmas.order.Orders;
import java.util.Map;
import java.util.Optional;

public class WeekendDiscount implements DiscountStrategy {

    @Override
    public Optional<DiscountEvent> discount(Orders orders) {
        int discountPrice = 0;
        Map<Item, Integer> orderMap = orders.getOrders();

        for (Item item : orderMap.keySet()) {
            if (item.getType() == FoodType.DESSERT) {
                discountPrice += 2023 * orderMap.get(item);
            }
        }

        if (CalendarChecker.isWeekend(orders.getOrderDate())) {
            return Optional.of(new DiscountEvent("주말 할인", discountPrice));
        }
        return Optional.empty();
    }
}
