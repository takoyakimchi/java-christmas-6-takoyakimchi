package christmas.event;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekendChecker {

    public static boolean isWeekend(int orderDate) {
        LocalDate date = LocalDate.of(EventConfig.EVENT_YEAR, EventConfig.EVENT_MONTH, orderDate);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }
}

