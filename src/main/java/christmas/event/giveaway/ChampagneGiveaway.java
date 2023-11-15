package christmas.event.giveaway;

import christmas.db.ItemRepository;
import christmas.event.domain.GiveawayEvent;
import christmas.item.Item;
import christmas.item.ItemMap;
import christmas.order.Orders;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ChampagneGiveaway implements GiveawayStrategy {

    @Override
    public Optional<GiveawayEvent> giveaway(Orders orders) {
        if (orders.getTotalPrice() >= 120000) {
            Item champagne = ItemRepository.findByName("샴페인")
                .orElseThrow(() -> new RuntimeException("증정 아이템이 존재하지 않습니다."));

            Map<Item, Integer> giveawayItemMap = new HashMap<>();
            giveawayItemMap.put(champagne, 1);
            return Optional.of(new GiveawayEvent("증정 이벤트", new ItemMap(giveawayItemMap)));
        }
        return Optional.empty();
    }
}
