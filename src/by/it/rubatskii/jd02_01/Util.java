package by.it.rubatskii.jd02_01;

class Util {

    public static int random(int max) {
        return random(0,max);
    }

    public static int random(int from, int to) {
        return from+(int)(Math.random()*(to-from+1));
    }

   static void sleep(int timeout) {
       try {
           Thread.sleep(timeout/Dispatcher.KSpeed);
       } catch (InterruptedException e) {
          //stub;
       }

   }
}
