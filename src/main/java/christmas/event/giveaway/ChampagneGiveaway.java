package christmas.event.giveaway;

import christmas.event.Event;
import christmas.item.FoodType;
import christmas.item.Item;
import christmas.order.Order;
import christmas.order.Orders;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChampagneGiveaway implements GiveawayStrategy {

    @Override
    public Optional<Event> giveaway(Orders orders) {
        if (orders.getTotalPrice() >= 120000) {
            Item champagne = new Item("샴페인", 25000, FoodType.BEVERAGE);
            Order giveaway = new Order(champagne, 1);
            List<Order> giveaways = new ArrayList<>(List.of(giveaway));
            return Optional.of(new Event("증정 이벤트", 0, giveaways));
        }
        return Optional.empty();
    }
}
