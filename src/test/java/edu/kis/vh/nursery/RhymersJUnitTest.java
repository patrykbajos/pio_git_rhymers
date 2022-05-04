package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;
import edu.kis.vh.nursery.list.IntLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class RhymersJUnitTest {
    private static final int TEST_VALUE = 4;
    private static final int COUNTING_VALUE = 888;

    private static final int STACK_CAPACITY = 12;
    private static final int EMPTY_STACK_VALUE = -1;

    public static final int ILL_VALUE_1 = 21;
    public static final int ILL_VALUE_2 = 37;

    @Test
    public void testCountIn() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        rhymer.countIn(TEST_VALUE);

        int result = rhymer.peekaboo();
        Assert.assertEquals(TEST_VALUE, result);
    }

    @Test
    public void testCallCheck() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        boolean result = rhymer.callCheck();
        Assert.assertEquals(true, result);

        rhymer.countIn(COUNTING_VALUE);

        result = rhymer.callCheck();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testIsFull() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();

        for (int i = 0; i < STACK_CAPACITY; i++) {
            boolean result = rhymer.isFull();
            Assert.assertEquals(false, result);
            rhymer.countIn(COUNTING_VALUE);
        }

        boolean result = rhymer.isFull();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testPeekaboo() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();

        int result = rhymer.peekaboo();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        rhymer.countIn(TEST_VALUE);

        result = rhymer.peekaboo();
        Assert.assertEquals(TEST_VALUE, result);
        result = rhymer.peekaboo();
        Assert.assertEquals(TEST_VALUE, result);
    }

    @Test
    public void testCountOut() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();

        int result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        rhymer.countIn(TEST_VALUE);

        result = rhymer.countOut();
        Assert.assertEquals(TEST_VALUE, result);
        result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);
    }

    // 14. wszystkie testy wykonuja sie poprawnie, brak zmian

    @Test
    public void testDefaultRhymersFactory() {
        RhymersFactory rhymersFactory = new DefaultRhymersFactory();

        Assert.assertNotNull(rhymersFactory.getStandardRhymer());
        Assert.assertNotNull(rhymersFactory.getFalseRhymer());
        Assert.assertNotNull(rhymersFactory.getFIFORhymer());
        Assert.assertNotNull(rhymersFactory.getHanoiRhymer());
    }

    @Test
    public void testIntLinkedList() {
        IntLinkedList list = new IntLinkedList();
        Assert.assertTrue(list.isEmpty());

        list.push(ILL_VALUE_1);
        Assert.assertEquals(list.top(), ILL_VALUE_1);
        Assert.assertFalse(list.isEmpty());

        list.push(ILL_VALUE_2);
        Assert.assertEquals(list.pop(), ILL_VALUE_2);
        Assert.assertEquals(list.pop(), ILL_VALUE_1);

        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void testFIFORhymer() {
        FIFORhymer rhymer = new FIFORhymer();

        rhymer.countIn(1);
        rhymer.countIn(2);
        rhymer.countIn(3);

        Assert.assertEquals(rhymer.countOut(), 1);
        Assert.assertEquals(rhymer.countOut(), 2);
        Assert.assertEquals(rhymer.countOut(), 3);

        Assert.assertTrue(rhymer.callCheck());
    }

    @Test
    public void testHanoiRhymer() {
        HanoiRhymer rhymer = new HanoiRhymer();

        rhymer.countIn(TEST_VALUE);
        Assert.assertEquals(TEST_VALUE, rhymer.peekaboo());
    }
}
// alt + strzałka zmienia karty w edytorze
