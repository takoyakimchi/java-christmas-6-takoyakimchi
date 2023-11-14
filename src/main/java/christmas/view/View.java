package christmas.view;

import static christmas.view.InputView.readDate;
import static christmas.view.InputView.readOrders;
import static christmas.view.OutputView.printBenefitList;
import static christmas.view.OutputView.printEventBadge;
import static christmas.view.OutputView.printEventPreviewMessage;
import static christmas.view.OutputView.printGiveawayItem;
import static christmas.view.OutputView.printGreeting;
import static christmas.view.OutputView.printMenu;
import static christmas.view.OutputView.printPayPrice;
import static christmas.view.OutputView.printPriceBeforeDiscount;
import static christmas.view.OutputView.printTotalBenefitPrice;

import christmas.event.domain.Events;
import christmas.order.Orders;

public class View {

    public static void start() {
        printGreeting();
        Orders orders = readDate();
        readOrders(orders);
        Events events = new Events(orders);
        printEventPreviewMessage(orders.getOrderDate());

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
