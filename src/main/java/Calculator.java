public class Calculator {
    public static long calculatingFibonacciByPosition(long position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else {
            return calculatingFibonacciByPosition(position - 1) + calculatingFibonacciByPosition(position - 2);
        }
    }
}

