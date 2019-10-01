package by.it.zlotnikova.jd02_02;

class Utils {

    static int random(int max) {
        return (int) (Math.random() * (max + 1));
    }

    static int random(int from, int to) {
        return (int) (from + Math.random() * (to - from + 1));
    }

    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Dispatcher.kSpeed);
        } catch (InterruptedException e) {
            ///stub;
        }
    }
}