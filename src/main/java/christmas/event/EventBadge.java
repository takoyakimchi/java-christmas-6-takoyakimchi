package christmas.event;

import java.util.Arrays;

public enum EventBadge {

    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000),
    NONE("없음", 0);

    private final String name;
    private final int minPrice;

    EventBadge(String name, int minPrice) {
        this.name = name;
        this.minPrice = minPrice;
    }

    public static EventBadge getEventBadge(int price) {
        return Arrays.stream(EventBadge.values())
            .filter(p -> p.minPrice <= price)
            .findFirst()
            .orElse(NONE);
    }

    public String getName() {
        return name;
    }
}
