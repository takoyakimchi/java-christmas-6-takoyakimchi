package christmas.order;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.db.ItemRepository;
import christmas.item.Item;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrdersTest {

    @Test
    @DisplayName("할인 전 전체 가격 구하기")
    void getTotalPrice() {
        // given
        Item steak = ItemRepository.findByName("티본스테이크").orElseThrow(RuntimeException::new);
        Item zeroCoke = ItemRepository.findByName("제로콜라").orElseThrow(RuntimeException::new);
        Map<Item, Integer> map = new HashMap<>() {{
            put(steak, 2);
            put(zeroCoke, 2);
        }};

        // when
        Orders orders = new Orders(new OrderDate(1), new OrderItemMap(map));
        int totalPrice = orders.getTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(steak.getPrice() * 2 + zeroCoke.getPrice() * 2);
    }
}