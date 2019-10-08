package by.it.yakimovich.jd02_01;

public class Util {
    public static int random(int max) {
        return random(0,max);
    }
    public static int random(int from, int to) {
        return from+(int)(Math.random()*(to-from+1));
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout/Dispatcher.kSpeed);
        } catch (Exception e) {
            //stub;
        }
    }
}
