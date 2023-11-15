package christmas.order;

import christmas.event.CalendarChecker;

public class OrderDate {

    private final int date;

    public OrderDate(int date) {
        validate(date);
        this.date = date;
    }

    public int getDate() {
        return date;
    }

    private void validate(int date) {
        if (date < 1 || date > CalendarChecker.getLastDayOfMonth()) {
            throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}