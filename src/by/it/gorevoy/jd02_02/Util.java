package by.it.gorevoy.jd02_02;
public class Util {
    public static int random (int max) {
        return random(0, max);
    }

    public static int random (int from, int to) {
        return from + (int)(Math.random()*(to-from+1));
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout/ Dispathcher.kSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}