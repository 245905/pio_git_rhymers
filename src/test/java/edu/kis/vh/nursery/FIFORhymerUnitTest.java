package edu.kis.vh.nursery;

import org.junit.Assert;
import org.junit.Test;

public class FIFORhymerUnitTest {

    @Test
    public void testCountIn() {
        FIFORhymer rhymer = new FIFORhymer();
        int testValue = 4;
        rhymer.countIn(testValue);

        int result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCallCheck() {
        FIFORhymer rhymer = new FIFORhymer();
        boolean result = rhymer.callCheck();
        Assert.assertEquals(true, result);

        rhymer.countIn(888);

        result = rhymer.callCheck();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testIsFull() {
        FIFORhymer rhymer = new FIFORhymer();
        final int STACK_CAPACITY = FIFORhymer.CAPACITY;
        for (int i = 0; i < STACK_CAPACITY; i++) {
            boolean result = rhymer.isFull();
            Assert.assertEquals(false, result);
            rhymer.countIn(888);
        }

        boolean result = rhymer.isFull();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testPeekaboo() {
        FIFORhymer rhymer = new FIFORhymer();
        final int EMPTY_STACK_VALUE = FIFORhymer.IF_EMPTY;

        int result = rhymer.peekaboo();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);

        int testValue2 = 5;
        rhymer.countIn(testValue2);

        result = rhymer.peekaboo();
        Assert.assertEquals(testValue2, result);
    }

    @Test
    public void testCountOut() {
        FIFORhymer rhymer = new FIFORhymer();
        final int EMPTY_STACK_VALUE = FIFORhymer.IF_EMPTY;

        int result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        int testValue2 = 5;
        rhymer.countIn(testValue);
        rhymer.countIn(testValue2);

        result = rhymer.countOut();
        Assert.assertEquals(testValue, result);
        result = rhymer.countOut();
        Assert.assertEquals(testValue2, result);
        result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);
    }

}
