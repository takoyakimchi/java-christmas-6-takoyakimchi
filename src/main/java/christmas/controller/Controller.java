package christmas.controller;

import static christmas.view.OutputView.printEventPreviewMessage;
import static christmas.view.OutputView.printGreeting;
import static christmas.view.OutputView.printResult;

import christmas.event.domain.Events;
import christmas.order.OrderDate;
import christmas.order.OrderItemMap;
import christmas.order.Orders;
import christmas.view.InputView;
import christmas.view.IterativeReader;

public class Controller {

    public static void start() {
        printGreeting();

        OrderDate orderDate = IterativeReader.read(InputView::readDate);
        OrderItemMap itemMap = IterativeReader.read(InputView::readOrders);

        Orders orders = new Orders(orderDate, itemMap);
        Events events = new Events(orders);

        printEventPreviewMessage(orders.getOrderDate());
        printResult(orders, events);
    }
}