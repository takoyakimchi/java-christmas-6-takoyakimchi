package christmas.db;

import christmas.item.FoodType;
import christmas.item.Item;
import java.util.ArrayList;
import java.util.List;

public class ItemData {

    public static List<Item> itemData() {
        return new ArrayList<>(List.of(
            new Item("양송이수프", 6000, FoodType.APPETIZER),
            new Item("타파스", 5500, FoodType.APPETIZER),
            new Item("시저샐러드", 8000, FoodType.APPETIZER),

            new Item("티본스테이크", 55000, FoodType.MAIN),
            new Item("바비큐립", 54000, FoodType.MAIN),
            new Item("해산물파스타", 35000, FoodType.MAIN),
            new Item("크리스마스파스타", 25000, FoodType.MAIN),

            new Item("초코케이크", 15000, FoodType.DESSERT),
            new Item("아이스크림", 5000, FoodType.DESSERT),

            new Item("제로콜라", 3000, FoodType.BEVERAGE),
            new Item("레드와인", 60000, FoodType.BEVERAGE),
            new Item("샴페인", 25000, FoodType.BEVERAGE)
        ));
    }
}
