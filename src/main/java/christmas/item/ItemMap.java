package christmas.item;

import java.util.Map;
import java.util.Set;

public class ItemMap {

    private final Map<Item, Integer> map;

    public ItemMap(Map<Item, Integer> map) {
        this.map = map;
    }

    public Set<Item> getKeySet() {
        return map.keySet();
    }

    public Integer getAmount(Item item) {
        return map.get(item);
    }
}
