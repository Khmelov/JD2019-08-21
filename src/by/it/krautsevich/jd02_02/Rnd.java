package by.it.krautsevich.jd02_02;

import java.util.Random;

class Rnd {

   static final long init = System.currentTimeMillis() ;
   static final Random random = new Random(init) ;

   static int fromTo (int from , int to) {

       int delta = to - from + 1 ;
       int msWait = from + random.nextInt(delta) ;
       return msWait ;

   }
}
