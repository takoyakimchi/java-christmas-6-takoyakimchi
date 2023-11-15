package christmas.db;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.item.Item;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemRepositoryTest {

    @Test
    @DisplayName("DB에서 아이템 찾기 성공")
    void findByName() {
        String foodName = "양송이수프";
        Optional<Item> foundItem = ItemRepository.findByName(foodName);
        assertThat(foundItem.get().getName()).isEqualTo(foodName);
    }

    @Test
    @DisplayName("DB에서 아이템 찾기 실패")
    void findByName_empty() {
        Optional<Item> foundItem = ItemRepository.findByName("asdfasdf");
        assertThat(foundItem).isEmpty();
    }
}