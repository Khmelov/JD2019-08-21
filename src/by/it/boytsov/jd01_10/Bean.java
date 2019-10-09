package by.it.boytsov.jd01_10;

public class Bean {
     double sum (int a, int b){
         return a+b;
    }
    @Param(a=11, b=23)
     double max (int a, int b){
         return a>b?a:b;
    }
    @Param(a=11, b=2)
      static  double min (int a, int b){
         return a<b?a:b;
    }
    @Param(a=11, b=23)
     static  double avg (int a, int b){
         return (a+b)/2.0;
    }
}
