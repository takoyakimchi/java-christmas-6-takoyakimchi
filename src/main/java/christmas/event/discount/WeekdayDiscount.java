package christmas.event.discount;

import christmas.event.CalendarChecker;
import christmas.event.domain.DiscountEvent;
import christmas.item.FoodType;
import christmas.item.Item;
import christmas.order.Orders;
import java.util.Optional;

public class WeekdayDiscount implements DiscountStrategy {

    @Override
    public Optional<DiscountEvent> discount(Orders orders) {
        int discountPrice = 0;

        for (Item item : orders.getItemMap().getKeySet()) {
            if (item.getType() == FoodType.DESSERT) {
                discountPrice += 2023 * orders.getItemMap().getAmount(item);
            }
        }

        if (!CalendarChecker.isWeekend(orders.getOrderDate())) {
            return Optional.of(new DiscountEvent("평일 할인", discountPrice));
        }
        return Optional.empty();
    }
}
