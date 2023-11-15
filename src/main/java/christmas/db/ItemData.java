package christmas.db;

import static christmas.item.FoodType.*;

import christmas.item.Item;
import java.util.ArrayList;
import java.util.List;

public class ItemData {

    public static List<Item> itemData() {
        return new ArrayList<>(List.of(
            new Item("양송이수프", 6000, APPETIZER),
            new Item("타파스", 5500, APPETIZER),
            new Item("시저샐러드", 8000, APPETIZER),

            new Item("티본스테이크", 55000, MAIN),
            new Item("바비큐립", 54000, MAIN),
            new Item("해산물파스타", 35000, MAIN),
            new Item("크리스마스파스타", 25000, MAIN),

            new Item("초코케이크", 15000, DESSERT),
            new Item("아이스크림", 5000, DESSERT),

            new Item("제로콜라", 3000, BEVERAGE),
            new Item("레드와인", 60000, BEVERAGE),
            new Item("샴페인", 25000, BEVERAGE)
        ));
    }
}
