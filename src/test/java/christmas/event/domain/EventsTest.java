package christmas.event.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.db.ItemRepository;
import christmas.item.Item;
import christmas.order.OrderDate;
import christmas.order.OrderItemMap;
import christmas.order.Orders;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventsTest {

    Orders orders;
    OrderDate orderDate;
    OrderItemMap orderItemMap;
    Events events;

    Item steak = ItemRepository.findByName("티본스테이크").orElseThrow(RuntimeException::new);
    Item bbqRib = ItemRepository.findByName("바비큐립").orElseThrow(RuntimeException::new);
    Item iceCream = ItemRepository.findByName("아이스크림").orElseThrow(RuntimeException::new);

    @BeforeEach
    void beforeEach() {
        orderDate = new OrderDate(25);

        Map<Item, Integer> itemMap = new HashMap<>();
        itemMap.put(steak, 5);
        itemMap.put(bbqRib, 5);
        itemMap.put(iceCream, 5);
        orderItemMap = new OrderItemMap(itemMap);

        orders = new Orders(orderDate, orderItemMap);
        events = new Events(orders);
    }

    @Test
    @DisplayName("전체 할인금액: 디데이 + 평일 + 특별")
    void getTotalDiscountPrice() {
        assertThat(events.getTotalDiscountPrice())
            .isEqualTo(3400 + 2023 * 5 + 1000);
    }

    @Test
    @DisplayName("전체 혜택금액: 디데이 + 평일 + 특별 + 증정품")
    void getTotalBenefitPrice() {
        assertThat(events.getTotalBenefitPrice())
            .isEqualTo(3400 + 2023 * 5 + 1000 + 25000);
    }
}