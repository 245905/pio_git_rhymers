package edu.kis.vh.nursery;

/**
 * Rhymer, which can add elements up to CAPACITY
 * and behaves as FIFO queue.
 */
public class FIFORhymer extends DefaultCountingOutRhymer {

    final DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();

    /**
     * Deletes the first element of Rhymer
     * and returns it.
     *
     * @return value of first element or IF_EMPTY, if empty.
     */
    @Override
    public int countOut() {
        while (!callCheck())
            temp.countIn(super.countOut());

        int ret = temp.countOut();

        while (!temp.callCheck())
            countIn(temp.countOut());

        return ret;
    }
}
