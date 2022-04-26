package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    private final int EMPTY_INITIALIZER = -1;
    private final int NUMBERS_LEN = 12;

    private final int[] numbers = new int[NUMBERS_LEN];

    public int total = EMPTY_INITIALIZER;

    public void countIn(int in) {
        if (!isFULL())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == EMPTY_INITIALIZER;
    }

    public boolean isFULL() {
        return total == (NUMBERS_LEN -1);
    }

    protected int peekaboo() {
        if (callCheck())
            return EMPTY_INITIALIZER;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return EMPTY_INITIALIZER;
        return numbers[total--];
    }

}
