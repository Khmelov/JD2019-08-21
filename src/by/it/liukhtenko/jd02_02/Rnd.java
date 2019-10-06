package by.it.liukhtenko.jd02_02;

import java.util.Random;

class Rnd {
    private static final long init  = System.currentTimeMillis();
    private static final Random random = new Random(init);

     static int fromTo(int from, int to){
      int delta = to - from;
      return from + random.nextInt(delta);
     }
}
