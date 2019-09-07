package by.it.liukhtenko.jd01_07;

import java.util.Arrays;

class Vector extends Var{
    private double [] value;
     Vector (double [] value){
         this.value = value;
     }
     Vector (String StrVector){
         StrVector = StrVector.substring(1,StrVector.length()-1);
         String [] converter = StrVector.split(",");
         value = new double[converter.length];
         for (int i=0; i<converter.length;i++){
             value[i] = Double.parseDouble(converter[i]);
         }

     }
     Vector (Vector vector){
         this.value = vector.value;
     }

    //@Override
   /* public String toString2() {
        String s = Arrays.toString(value);
        s= s.substring(1,s.length()-1);
        return "{" +
                s+
                '}';
    }*/

   /* @Override
    public String toString(){
        String s = "{";
        String delimetr = "";
        for (double v : value) {
            s += delimetr+ v;
            delimetr = ", ";
        }

         s += "}";
        return s;*/

       // return Arrays.toString(value).replace('[','{').replace(']','}');
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";

        }
        sb.append("}");
        return sb.toString();
    }
}
