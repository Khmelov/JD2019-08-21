package by.it.agadzhanov.jd02_02;

class Util {

    static int randomUpTo(int max) {
        return randomFromTo(0, max);
    }

    static int randomFromTo(int from, int to) {
        return from + (int) (Math.random() * (to - from + 1));
    }

    static void sleepAccelerated(int millis) throws InterruptedException {
        Thread.sleep(millis / Dispatcher.timeFactor);
    }

    static void sleepPensioner(int millis) throws InterruptedException {
        Thread.sleep((long) (Dispatcher.pensionerFactor * millis / Dispatcher.timeFactor));
    }
}
