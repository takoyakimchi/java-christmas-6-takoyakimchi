package christmas.item;

public class Item {

    private String name;
    private int price;
    private FoodType type;

    public Item(String name, int price, FoodType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public FoodType getType() {
        return type;
    }
}
