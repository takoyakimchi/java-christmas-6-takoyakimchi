package christmas.db;

import christmas.item.Item;
import java.util.Optional;

public class ItemRepository {

    public static Optional<Item> findByName(String name) {
        for (Item item : ItemData.itemData()) {
            if (item.getName().equals(name)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }
}
