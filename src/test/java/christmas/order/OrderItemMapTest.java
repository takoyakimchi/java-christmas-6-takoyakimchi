package christmas.order;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.db.ItemRepository;
import christmas.item.Item;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderItemMapTest {

    Map<Item, Integer> map = new HashMap<>();
    Item steak = ItemRepository.findByName("티본스테이크").orElseThrow(RuntimeException::new);
    Item zeroCoke = ItemRepository.findByName("제로콜라").orElseThrow(RuntimeException::new);
    Item champagne = ItemRepository.findByName("샴페인").orElseThrow(RuntimeException::new);

    @Test
    @DisplayName("음료만 주문 시 예외 발생")
    void orderBeverageOnly() {
        map.put(zeroCoke, 5);
        map.put(champagne, 5);
        assertThatThrownBy(() -> new OrderItemMap(map))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("20개 초과 주문 시 예외 발생")
    void orderMoreThanTwentyItems() {
        map.put(steak, 10);
        map.put(champagne, 11);
        assertThatThrownBy(() -> new OrderItemMap(map))
            .isInstanceOf(IllegalArgumentException.class);
    }
}