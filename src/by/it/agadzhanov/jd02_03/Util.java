package by.it.agadzhanov.jd02_03;

class Util {

    static int randomUpTo(int max) {
        return randomFromTo(0, max);
    }

    static int randomFromTo(int from, int to) {
        return from + (int) (Math.random() * (to - from + 1));
    }

    static void sleepAccelerated(int millis) {
        try {
            Thread.sleep(millis / Dispatcher.timeFactor);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void sleepPensioner(int millis) {
        try {
            Thread.sleep((long) (Dispatcher.pensionerFactor * millis / Dispatcher.timeFactor));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
