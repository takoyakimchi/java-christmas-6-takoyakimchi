package christmas.event.discount;

import static java.time.DayOfWeek.SUNDAY;

import christmas.event.CalendarChecker;
import christmas.event.domain.DiscountEvent;
import christmas.order.Orders;
import java.util.Optional;

public class SpecialDayDiscount implements DiscountStrategy {

    @Override
    public Optional<DiscountEvent> discount(Orders orders) {
        int orderDate = orders.getOrderDate();
        if (CalendarChecker.getDayOfWeek(orderDate) == SUNDAY || orderDate == 25) {
            return Optional.of(new DiscountEvent("특별 할인", 1000));
        }
        return Optional.empty();
    }
}