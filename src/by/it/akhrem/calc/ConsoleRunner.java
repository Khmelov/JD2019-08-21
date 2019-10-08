package by.it.akhrem.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        for(;;) {
            String expression = sc.nextLine();
            if (expression.equals("end")) break;
            if (expression.equals("printvar")) Var.printvar();
            Locale locale;

            if (expression.equals("ru")) {
                locale = new Locale("ru", "RU");
                Var.rm.setLocale(locale);
                continue;
            }
            if (expression.equals("be"))  {
                locale = new Locale("be", "BY");
                Var.rm.setLocale(locale);
                continue;
            }
            if (expression.equals("en")) {
                locale = Locale.ENGLISH;
                Var.rm.setLocale(locale);
                continue;
            }

            try {
                Var result = parser.calc(expression);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
