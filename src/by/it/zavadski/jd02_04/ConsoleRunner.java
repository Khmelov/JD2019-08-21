package by.it.zavadski.jd02_04;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {
        Scanner sc = new Scanner(System.in);
        Parser parser=new Parser();
        Printer printer=new Printer();
        String expression;
       while (!(expression=sc.nextLine()).equals("end")){
            //Var result=parser.calc(expression);
            try {
                Var result=parser.calc(expression);
                printer.print(result);
            } catch (CalcException |ArithmeticException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
