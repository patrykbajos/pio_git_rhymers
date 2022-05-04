package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {
    private static final int EMPTY_INITIALIZER = -1;
    private static final int NUMBERS_LEN = 12;

    private final int[] numbers = new int[NUMBERS_LEN];
    private int total = EMPTY_INITIALIZER;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        // TODO: Sugeruje poprawic nazwe metody na 'isEmpty'
        return total == EMPTY_INITIALIZER;
    }

    public boolean isFull() {
        return total == (NUMBERS_LEN - 1);
    }

    protected int peekaboo() {
        // TODO: Sugeruje zmienic nazwe metody na 'top'
        if (callCheck())
            return EMPTY_INITIALIZER;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return EMPTY_INITIALIZER;
        return numbers[total--];
    }

    public int getTotal() {
        return total;
    }
}
