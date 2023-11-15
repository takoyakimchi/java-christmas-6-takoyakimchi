package christmas.view;

import static christmas.event.EventConst.EVENT_MONTH;

import christmas.event.EventBadge;
import christmas.event.domain.DiscountEvent;
import christmas.event.domain.Events;
import christmas.event.domain.GiveawayEvent;
import christmas.item.Item;
import christmas.item.ItemMap;
import christmas.order.Orders;

public class OutputView {

    public static void printResult(Orders orders, Events events) {
        printMenu(orders);
        printPriceBeforeDiscount(orders);
        printGiveawayItem(events);
        printBenefitList(events);
        printTotalBenefitPrice(events);
        printPayPrice(orders, events);
        printEventBadge(events);
    }

    public static void printGreeting() {
        System.out.println("안녕하세요! 우테코 식당 " + EVENT_MONTH + "월 이벤트 플래너입니다.");
    }

    public static void printEventPreviewMessage(int orderDate) {
        System.out.println(
            EVENT_MONTH + "월 " + orderDate + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    private static void printMenu(Orders orders) {
        System.out.println();
        System.out.println("<주문 메뉴>");
        printItemMap(orders.getItemMap());
    }

    private static void printPriceBeforeDiscount(Orders orders) {
        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원\n", orders.getTotalPrice());
    }

    private static void printGiveawayItem(Events events) {
        System.out.println();
        System.out.println("<증정 메뉴>");
        for (GiveawayEvent event : events.getGiveawayEvents()) {
            printItemMap(event.getGiveawayItemMap());
        }
        if (events.getGiveawayEvents().isEmpty()) {
            System.out.println("없음");
        }
    }

    private static void printBenefitList(Events events) {
        System.out.println();
        System.out.println("<혜택 내역>");
        for (DiscountEvent event : events.getDiscountEvents()) {
            printDiscountEvent(event);
        }
        for (GiveawayEvent event : events.getGiveawayEvents()) {
            printGiveawayEvent(event);
        }
        if (events.getDiscountEvents().isEmpty() && events.getGiveawayEvents().isEmpty()) {
            System.out.println("없음");
        }
    }

    private static void printTotalBenefitPrice(Events events) {
        System.out.println();
        System.out.println("<총혜택 금액>");
        System.out.printf("%,d원\n", events.getTotalBenefitPrice() * (-1));
    }

    private static void printPayPrice(Orders orders, Events events) {
        int payPrice = orders.getTotalPrice() - events.getTotalDiscountPrice();
        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원\n", payPrice);
    }

    private static void printEventBadge(Events events) {
        EventBadge badge = EventBadge.getEventBadge(events.getTotalBenefitPrice());
        System.out.println();
        System.out.println("<" + EVENT_MONTH + "월 이벤트 배지>");
        System.out.println(badge.getName());
    }

    private static void printItemMap(ItemMap itemMap) {
        for (Item item : itemMap.getKeySet()) {
            System.out.println(item.getName() + ": " + itemMap.getAmount(item) + "개");
        }
    }

    private static void printDiscountEvent(DiscountEvent event) {
        System.out.print(event.getDescription() + ": ");
        System.out.printf("%,d원\n", event.getDiscountPrice() * (-1));
    }

    private static void printGiveawayEvent(GiveawayEvent event) {
        System.out.print(event.getDescription() + ": ");
        System.out.printf("%,d원\n", event.getBenefitPrice() * (-1));
    }
}