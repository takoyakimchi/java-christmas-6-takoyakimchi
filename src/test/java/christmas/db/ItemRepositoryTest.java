package christmas.db;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import christmas.item.FoodType;
import christmas.item.Item;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ItemRepositoryTest {

    @Test
    void findByName() {
        String foodName = "양송이수프";
        Optional<Item> foundItem = ItemRepository.findByName(foodName);
        assertThat(foundItem.get().getName()).isEqualTo(foodName);
    }

    @Test
    void findByName_empty() {
        Optional<Item> foundItem = ItemRepository.findByName("asdfasdf");
        assertThat(foundItem).isEmpty();
    }
}