package christmas.event;

import static christmas.event.EventConst.EVENT_MONTH;
import static christmas.event.EventConst.EVENT_YEAR;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

public class CalendarChecker {

    public static boolean isWeekend(int orderDate) {
        LocalDate date = LocalDate.of(EVENT_YEAR, EVENT_MONTH, orderDate);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    public static int getLastDayOfMonth() {
        return YearMonth.of(EVENT_YEAR, EVENT_MONTH)
            .atEndOfMonth()
            .getDayOfMonth();
    }
}