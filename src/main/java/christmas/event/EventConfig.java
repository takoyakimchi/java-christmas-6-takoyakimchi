package christmas.event;

import christmas.event.discount.DdayDiscount;
import christmas.event.discount.DiscountStrategy;
import christmas.event.discount.SpecialDayDiscount;
import christmas.event.discount.WeekdayDiscount;
import christmas.event.discount.WeekendDiscount;
import christmas.event.giveaway.ChampagneGiveaway;
import christmas.event.giveaway.GiveawayStrategy;
import java.util.ArrayList;
import java.util.List;

public class EventConfig {

    public static List<DiscountStrategy> discountStrategies() {
        return new ArrayList<>(List.of(
            new DdayDiscount(),
            new SpecialDayDiscount(),
            new WeekdayDiscount(),
            new WeekendDiscount()
        ));
    }

    public static List<GiveawayStrategy> giveawayStrategies() {
        return new ArrayList<>(List.of(
            new ChampagneGiveaway()
        ));
    }
}