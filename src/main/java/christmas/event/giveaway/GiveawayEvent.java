package christmas.event.giveaway;

import christmas.order.Order;
import java.util.List;

public class GiveawayEvent {

    private final String description;
    private final List<Order> giveawayItems;

    public GiveawayEvent(String description, List<Order> giveawayItems) {
        this.description = description;
        this.giveawayItems = giveawayItems;
    }

    public String getDescription() {
        return description;
    }

    public int getBenefitPrice() {
        int benefitPrice = 0;
        for (Order giveawayItem : giveawayItems) {
            benefitPrice += giveawayItem.getItem().getPrice() * giveawayItem.getAmount();
        }
        return benefitPrice;
    }

    public List<Order> getGiveawayItems() {
        return giveawayItems;
    }
}
