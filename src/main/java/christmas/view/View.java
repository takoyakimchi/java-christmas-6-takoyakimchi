package christmas.view;

import static christmas.view.InputView.*;
import static christmas.view.OutputView.*;

import christmas.event.Events;
import christmas.order.Orders;

public class View {

    public static void start() {
        printGreeting();
        int orderDate = readDate();
        Orders orders = readOrders(orderDate);
        Events events = new Events(orders);
        printEventPreviewMessage(orderDate);

        printResult(orders, events);
    }

    private static void printResult(Orders orders, Events events) {
        printMenu(orders);
        printPriceBeforeDiscount(orders);
        printGiveawayItem(events);
        printBenefitList(events);
        printTotalBenefitPrice(events);
        printPayPrice(orders, events);
        printEventBadge(events);
    }
}
