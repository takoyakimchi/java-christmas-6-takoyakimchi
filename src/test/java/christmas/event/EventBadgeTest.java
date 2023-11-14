package christmas.event;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class EventBadgeTest {

    @Test
    void getEventBadge() {
        EventBadge eventBadge1 = EventBadge.getEventBadge(20000);
        EventBadge eventBadge2 = EventBadge.getEventBadge(10000);
        EventBadge eventBadge3 = EventBadge.getEventBadge(5000);
        EventBadge eventBadge4 = EventBadge.getEventBadge(4999);

        Assertions.assertThat(eventBadge1).isEqualTo(EventBadge.SANTA);
        Assertions.assertThat(eventBadge2).isEqualTo(EventBadge.TREE);
        Assertions.assertThat(eventBadge3).isEqualTo(EventBadge.STAR);
        Assertions.assertThat(eventBadge4).isEqualTo(EventBadge.NONE);
    }
}