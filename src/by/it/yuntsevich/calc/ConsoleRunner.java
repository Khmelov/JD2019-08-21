package by.it.yuntsevich.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        Var.readVars();
        ResourceManager manager = ResourceManager.INSTANCE;
        Locale.setDefault(Locale.ENGLISH);

        for(;;) {
            String expression = sc.nextLine();
            try {
                if (expression.equals("end")) break;
                if (expression.equals("printvar")) {
                    printer.printMap(Var.getVars());
                    continue;
                }
                if (expression.equals("sortvar")) {
                    printer.printSorted(Var.getVars());
                    continue;
                }
                if (expression.equals("en")){
                    manager.setLocale(Locale.ENGLISH);
                    continue;
                }
                if (expression.equals("ru")){
                    manager.setLocale(new Locale("ru", "RU"));
                    continue;
                }
                if (expression.equals("be")){
                    manager.setLocale(new Locale("be", "BY"));
                    continue;
                }

                Var result = parser.calc(expression);
                if (result != null) printer.print(result);
            }
            catch(CalcException e){
                System.out.println(e.getMessage());
            }
        }

    }
}
