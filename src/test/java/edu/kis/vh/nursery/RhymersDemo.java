package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;

class RhymersDemo {
    public static final int COUNTING_START = 1;
    public static final int COUNTING_STOP = 15;
    public static final int HANOI_RHYMER_I = 3;
    public static final int COUNT_RAND_MAX = 20;

    public static void main(String[] args) {
        final RhymersFactory factory = new DefaultRhymersFactory();

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