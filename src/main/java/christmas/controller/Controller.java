package christmas.controller;

import static christmas.view.InputView.readDate;
import static christmas.view.InputView.readOrders;
import static christmas.view.OutputView.printEventPreviewMessage;
import static christmas.view.OutputView.printGreeting;

import christmas.event.domain.Events;
import christmas.order.Orders;
import christmas.view.OutputView;

public class Controller {

    public static void start() {
        printGreeting();
        Orders orders = readDate();
        readOrders(orders);
        Events events = new Events(orders);
        printEventPreviewMessage(orders.getOrderDate());
        OutputView.printResult(orders, events);
    }
}
