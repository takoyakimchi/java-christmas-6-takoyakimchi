package christmas.order;

import christmas.item.Item;

public class Order {

    private Item item;
    private int amount;

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
