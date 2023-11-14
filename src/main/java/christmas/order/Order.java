package christmas.order;

import christmas.item.Item;

public class Order {

    private final Item item;
    private final int amount;

    public Order(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }
}
