package christmas.controller;

import static christmas.view.InputView.readDate;
import static christmas.view.InputView.readOrders;
import static christmas.view.OutputView.printEventPreviewMessage;
import static christmas.view.OutputView.printGreeting;
import static christmas.view.OutputView.printResult;

import christmas.event.domain.Events;
import christmas.item.Item;
import christmas.order.OrderDate;
import christmas.order.Orders;
import java.util.Map;

public class Controller {

    public static void start() {
        printGreeting();

        OrderDate orderDate = readDate();
        Map<Item, Integer> orderMap = readOrders();

        Orders orders = new Orders(orderDate, orderMap);
        Events events = new Events(orders);

        printEventPreviewMessage(orders.getOrderDate());
        printResult(orders, events);
    }
}
