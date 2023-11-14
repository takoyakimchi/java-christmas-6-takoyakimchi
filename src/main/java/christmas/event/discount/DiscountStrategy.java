package christmas.event.discount;

import christmas.event.Event;
import christmas.order.Orders;
import java.util.Optional;

public interface DiscountStrategy {

    Optional<Event> discount(Orders orders);
}
