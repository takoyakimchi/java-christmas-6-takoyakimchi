package christmas.event;

import christmas.event.discount.DiscountStrategy;
import christmas.event.discount.DiscountEvent;
import christmas.event.giveaway.GiveawayEvent;
import christmas.event.giveaway.GiveawayStrategy;
import christmas.order.Orders;
import java.util.ArrayList;
import java.util.List;

public class Events {

    private List<DiscountEvent> discountEvents = new ArrayList<>();
    private List<GiveawayEvent> giveawayEvents = new ArrayList<>();

    public Events(Orders orders) {
        if (orders.getTotalPrice() >= 10000) {
            for (DiscountStrategy discountStrategy : EventConfig.discountStrategies()) {
                discountStrategy.discount(orders).ifPresent(discountEvents::add);
            }
            for (GiveawayStrategy giveawayStrategy : EventConfig.giveawayStrategies()) {
                giveawayStrategy.giveaway(orders).ifPresent(giveawayEvents::add);
            }
        }
    }

    public List<DiscountEvent> getDiscountEvents() {
        return discountEvents;
    }

    public List<GiveawayEvent> getGiveawayEvents() {
        return giveawayEvents;
    }

    public int getTotalDiscountPrice() {
        int totalDiscountPrice = 0;
        for (DiscountEvent event : discountEvents) {
            totalDiscountPrice += event.getDiscountPrice();
        }
        return totalDiscountPrice;
    }

    public int getTotalBenefitPrice() {
        int totalBenefitPrice = getTotalDiscountPrice();
        for (GiveawayEvent event : giveawayEvents) {
            totalBenefitPrice += event.getBenefitPrice();
        }
        return totalBenefitPrice;
    }
}
