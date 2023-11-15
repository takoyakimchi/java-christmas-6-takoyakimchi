package christmas.order;

import static christmas.item.FoodType.BEVERAGE;

import christmas.item.Item;
import christmas.item.ItemMap;
import java.util.Map;

public class OrderItemMap extends ItemMap {

    public OrderItemMap(Map<Item, Integer> map) {
        super(map);
        validate(map);
    }

    private void validate(Map<Item, Integer> map) {
        validateOnlyBeverage(map);
        validateMaxAmount(map);
    }

    private void validateOnlyBeverage(Map<Item, Integer> map) {
        int beverageCount = 0;
        for (Item item : map.keySet()) {
            if (item.getType() == BEVERAGE) {
                beverageCount++;
            }
        }

        if (beverageCount == map.size()) {
            throw new IllegalArgumentException("음료만 주문할 수 없습니다.");
        }
    }

    private void validateMaxAmount(Map<Item, Integer> map) {
        int amount = 0;
        for (Item item : map.keySet()) {
            amount += map.get(item);
        }
        if (amount > 20) {
            throw new IllegalArgumentException("최대 20개까지 주문할 수 있습니다.");
        }
    }
}