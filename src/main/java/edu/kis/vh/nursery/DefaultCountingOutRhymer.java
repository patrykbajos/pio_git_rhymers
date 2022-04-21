package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    private  int CHECK = -1;
    private  int STACK_CAPACITY = 12;
    private  int FULL = 11;
    private int[] numbers = new int[STACK_CAPACITY];

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
