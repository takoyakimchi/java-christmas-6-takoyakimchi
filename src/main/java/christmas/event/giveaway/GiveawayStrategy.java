package christmas.event.giveaway;

import christmas.event.Event;
import christmas.order.Orders;
import java.util.Optional;

public interface GiveawayStrategy {

    Optional<Event> giveaway(Orders orders);
}
