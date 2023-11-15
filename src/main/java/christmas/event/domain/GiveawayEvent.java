package christmas.event.domain;

import christmas.item.Item;
import christmas.item.ItemMap;

public class GiveawayEvent {

    private final String description;
    private final ItemMap giveawayItemMap;

    public GiveawayEvent(String description, ItemMap giveawayItems) {
        this.description = description;
        this.giveawayItemMap = giveawayItems;
    }

    public String getDescription() {
        return description;
    }

    public int getBenefitPrice() {
        int benefitPrice = 0;
        for (Item item : giveawayItemMap.getKeySet()) {
            benefitPrice += item.getPrice() * giveawayItemMap.getAmount(item);
        }
        return benefitPrice;
    }

    public ItemMap getGiveawayItemMap() {
        return giveawayItemMap;
    }
}
