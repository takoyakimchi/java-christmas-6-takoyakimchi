package christmas.view;

import java.util.function.Supplier;

public class IterativeReader {

    public static final String ERROR_PREFIX = "[ERROR] ";

    public static <T> T read(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }
}