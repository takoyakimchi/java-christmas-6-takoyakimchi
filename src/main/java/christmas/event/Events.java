package christmas.event;

import christmas.event.discount.DiscountStrategy;
import christmas.event.giveaway.GiveawayStrategy;
import christmas.order.Order;
import christmas.order.Orders;
import java.util.ArrayList;
import java.util.List;

public class Events {

    private List<Event> events = new ArrayList<>();

    public Events(Orders orders) {
        if (orders.getTotalPrice() >= 10000) {
            for (DiscountStrategy discountStrategy : EventConfig.discountStrategies()) {
                discountStrategy.discount(orders).ifPresent(events::add);
            }
            for (GiveawayStrategy giveawayStrategy : EventConfig.giveawayStrategies()) {
                giveawayStrategy.giveaway(orders).ifPresent(events::add);
            }
        }
    }

    public List<Event> getEvents() {
        return events;
    }

    public int getTotalDiscountPrice() {
        int totalDiscountPrice = 0;
        for (Event event : events) {
            totalDiscountPrice += event.getDiscountPrice();
        }
        return totalDiscountPrice;
    }

    public int getTotalBenefitPrice() {
        int totalBenefitPrice = getTotalDiscountPrice();
        for (Event event : events) {
            List<Order> giveawayItems = event.getGiveawayItems();
            for (Order giveawayItem : giveawayItems) {
                totalBenefitPrice += giveawayItem.getItem().getPrice() * giveawayItem.getAmount();
            }
        }
        return totalBenefitPrice;
    }
}
