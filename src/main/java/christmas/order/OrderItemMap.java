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
        validateCount(map);
        validateOnlyBeverage(map);
        validateMaxAmount(map);
    }

    private void validateCount(Map<Item, Integer> map) {
        for (Item item : map.keySet()) {
            if (map.get(item) <= 0) {
                throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    private void validateOnlyBeverage(Map<Item, Integer> map) {
        int beverageCount = 0;
        for (Item item : map.keySet()) {
            if (item.getType() == BEVERAGE) {
                beverageCount++;
            }
        }

        if (beverageCount == map.size()) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateMaxAmount(Map<Item, Integer> map) {
        int amount = 0;
        for (Item item : map.keySet()) {
            amount += map.get(item);
        }
        if (amount > 20) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}