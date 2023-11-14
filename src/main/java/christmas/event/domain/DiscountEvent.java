package christmas.event.domain;

public class DiscountEvent {

    private final String description;
    private final int discountPrice;

    public DiscountEvent(String description, int discountPrice) {
        this.description = description;
        this.discountPrice = discountPrice;
    }

    public String getDescription() {
        return description;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }
}
