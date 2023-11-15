package christmas.event.giveaway;

import christmas.event.domain.GiveawayEvent;
import christmas.order.Orders;
import java.util.Optional;

public interface GiveawayStrategy {

    Optional<GiveawayEvent> giveaway(Orders orders);
}