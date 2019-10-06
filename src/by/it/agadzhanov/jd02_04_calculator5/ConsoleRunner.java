package by.it.agadzhanov.jd02_04_calculator5;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = scanner.nextLine()).equals("end")) {
            if (line.equals("printvar")) {
                Var.printVar();
                continue;
            }
            Var result = parser.calculateExpression(line);
            printer.print(result);
        }
    }
}
