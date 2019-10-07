package by.it.shamuradova.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        ResManager rm = ResManager.INSTANCE;

        for (; ; ) {
            String out = rm.getKey(Message.ENTER);
            System.out.println(out);
            String vyragenie = sc.nextLine();
            try {
                if (vyragenie.equals("end")) {
                    break;
                }
                if (vyragenie.equals("printvar")) {
                    printer.printMap(Var.getVars());
                }
                if (vyragenie.equals("sortvar")) {
                    printer.printSorted(Var.getVars());
                }
                if (vyragenie.equals("ru")) {
                    rm.setLocale(new Locale("ru", "RU"));
                }
                if (vyragenie.equals("be")) {
                    rm.setLocale(new Locale("be", "BY"));
                }
                if (vyragenie.equals("en")) {
                    rm.setLocale(new Locale("en", "US"));
                } else {
                    Var result = parser.calc(vyragenie);
                    printer.print(result);
                }
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
