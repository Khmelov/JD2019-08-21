package by.it.agadzhanov.jd02_01;

import java.util.Random;

class Util {

    private static final long seed = System.currentTimeMillis();
    private static final Random random = new Random(seed);

    static int randomUpTo(int max) {
        return randomFromTo(0, max);
    }

    static int randomFromTo(int from, int to) {
        return from + random.nextInt(to - from + 1);
    }

    static void sleepAccelerated(int millis) throws InterruptedException {
        Thread.sleep(millis / Dispatcher.timeFactor);
    }

    static void sleepPensioner(int millis) throws InterruptedException {
        Thread.sleep((long) (Dispatcher.pensionerFactor * millis / Dispatcher.timeFactor));
    }

}
