package christmas.event;

import christmas.order.Order;
import java.util.List;

public class Event {

    private final String description;
    private final int discountPrice;
    private final List<Order> giveawayItems;

    public Event(String description, int discountPrice, List<Order> giveawayItems) {
        this.description = description;
        this.discountPrice = discountPrice;
        this.giveawayItems = giveawayItems;
    }

    public String getDescription() {
        return description;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public int getBenefitPrice() {
        int benefitPrice = discountPrice;
        for (Order giveawayItem : giveawayItems) {
            benefitPrice += giveawayItem.getItem().getPrice() * giveawayItem.getAmount();
        }
        return benefitPrice;
    }

    public List<Order> getGiveawayItems() {
        return giveawayItems;
    }
}
