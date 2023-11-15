package christmas.db;

import christmas.item.Item;
import java.util.Optional;

public class ItemRepository {

    public static Optional<Item> findByName(String name) {
        return ItemData.itemData()
            .stream()
            .filter(x -> x.getName().equals(name))
            .findAny();
    }
}