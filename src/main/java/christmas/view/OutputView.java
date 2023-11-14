package christmas.view;

import christmas.event.Event;
import christmas.event.EventBadge;
import christmas.event.EventConfig;
import christmas.event.Events;
import christmas.order.Order;
import christmas.order.Orders;

public class OutputView {

    public static void printEventPreviewMessage(int orderDate) {
        System.out.println(
            EventConfig.EVENT_MONTH + "월 " + orderDate + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public static void printMenu(Orders orders) {
        System.out.println();
        System.out.println("<주문 메뉴>");
        for (Order order : orders.getOrders()) {
            printOrder(order);
        }
    }

    public static void printPriceBeforeDiscount(Orders orders) {
        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원\n", orders.getTotalPrice());
    }

    public static void printGiveawayItem(Events events) {
        System.out.println();
        System.out.println("<증정 메뉴>");
        for (Event event : events.getEvents()) {
            for (Order giveawayItem : event.getGiveawayItems()) {
                printOrder(giveawayItem);
            }
        }
    }

    public static void printBenefitList(Events events) {
        System.out.println();
        System.out.println("<혜택 내역>");
        for (Event event : events.getEvents()) {
            printEvent(event);
        }
    }

    public static void printTotalBenefitPrice(Events events) {
        System.out.println();
        System.out.println("<총혜택 금액>");
        System.out.printf("-%,d원\n", events.getTotalBenefitPrice());
    }

    public static void printPayPrice(Orders orders, Events events) {
        int payPrice = orders.getTotalPrice() - events.getTotalDiscountPrice();
        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원\n", payPrice);
    }

    public static void printEventBadge(Events events) {
        EventBadge badge = EventBadge.getEventBadge(events.getTotalBenefitPrice());
        System.out.println();
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge.getName());
    }

    private static void printOrder(Order order) {
        System.out.print(order.getItem().getName() + " ");
        System.out.println(order.getAmount() + "개");
    }

    private static void printEvent(Event event) {
        System.out.print(event.getDescription() + ": ");
        System.out.printf("-%,d원\n", event.getBenefitPrice());
    }
}