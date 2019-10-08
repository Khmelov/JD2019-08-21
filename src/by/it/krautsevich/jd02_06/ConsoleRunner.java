package by.it.krautsevich.jd02_06;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        Parser parser = new Parser() ;
        Printer printer = new Printer() ;
        PrinterVar var_printer = new PrinterVar() ;
        for (;;) {
            String expression = sc.nextLine();
            try {
                if (expression.equals("printvar")) {
                    var_printer.printVars(Var.giveMap());
                }
                if (expression.equals("sortvar")) {
                    var_printer.printSortedVars(Var.giveMap());
                }
                if (expression.equals("end")) break;
                Var result = parser.calc(expression);
                if (result != null) printer.print(result);
            } catch (CalcException | ArithmeticException e) {
                System.err.println(e.getMessage());
            }
        }
    }


}
