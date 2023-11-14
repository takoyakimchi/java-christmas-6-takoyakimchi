package christmas.event.discount;

import christmas.order.Orders;
import java.util.Optional;

public interface DiscountStrategy {

    Optional<DiscountEvent> discount(Orders orders);
}
