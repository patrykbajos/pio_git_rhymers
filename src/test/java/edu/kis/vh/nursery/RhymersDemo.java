package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;

class RhymersDemo {
    private static final int COUNTING_START = 1;
    private static final int COUNTING_STOP = 15;
    private static final int HANOI_RHYMER_I = 3;
    private static final int COUNT_RAND_MAX = 20;

    public static void main(String[] args) {
        testRhymers(new DefaultRhymersFactory());
    }

    private static void testRhymers(RhymersFactory factory) {
        DefaultCountingOutRhymer[] rhymers = {
            factory.getStandardRhymer(),
            factory.getFalseRhymer(),
            factory.getFIFORhymer(),
            factory.getHanoiRhymer()
        };

        for (int i = COUNTING_START; i < COUNTING_STOP; i++) {
            for (int j = 0; j < HANOI_RHYMER_I; j++) {
                rhymers[j].countIn(i);
            }
        }

        java.util.Random rn = new java.util.Random();
        for (int i = COUNTING_START; i < COUNTING_STOP; i++) {
            rhymers[HANOI_RHYMER_I].countIn(rn.nextInt(COUNT_RAND_MAX));
        }

        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck()) {
				System.out.print(rhymers[i].countOut() + "  ");
			}
            System.out.println();
        }

        System.out.println("total rejected is " + ((HanoiRhymer) rhymers[3]).reportRejected());
    }
}