package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    private final int CHECK = -1;
    private final int STACK_CAPACITY = 12;
    private final int FULL = 11;
    private final int[] numbers = new int[STACK_CAPACITY];

    public int total = CHECK;

    public void countIn(int in) {
        if (!getFULL())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == CHECK;
    }

    public boolean getFULL() {
        return total == FULL;
    }

    protected int peekaboo() {
        if (callCheck())
            return CHECK;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return CHECK;
        return numbers[total--];
    }

}
