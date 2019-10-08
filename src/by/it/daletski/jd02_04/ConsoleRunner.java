package by.it.daletski.jd02_04;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleRunner {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        try {
            Var.loadVars();
        } catch (CalcException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("The file vars.txt was not found. It will be recreated after the first variable is assigned...");
            e.printStackTrace();
        }
        for (; ; ) {
            try {
                String expression = sc.nextLine();
                if (expression.equals("end"))
                    break;
                Var result = parser.calc(expression);
                printer.print(result);
                if (expression.contains("="))
                    Var.saveVars();
            } catch (CalcException | ArithmeticException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
