package by.it.liukhtenko.jd02_04_calc;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws IOException, CalcException {
        Scanner sc = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        Var.loadVars();
      //  System.out.println(sc.nextLine());

        while (!(line = sc.nextLine()).equals("end")) {
            try {

                if ((line.equals("printvar"))) {
                    Var.printvar();
                    continue;
                } else if ((line.equals("sortvar"))) {
                    Var.sortvar();
                    continue;
                }
                Var result = parser.calc(line);
                printer.print(result);
            }catch (CalcException e ){
                System.out.println(e.getMessage());
            }
        }
    }
}
