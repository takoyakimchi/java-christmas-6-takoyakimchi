package christmas.db;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.item.Item;
import java.util.Optional;
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