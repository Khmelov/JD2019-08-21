package by.it.zhukovskaya.jd02_05.calc;

import java.util.Locale;
import java.util.Scanner;

import static by.it.zhukovskaya.jd02_05.calc.ResourceManager.INSTANCE;

public class ConsoleRunner {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ResourceManager resMan = INSTANCE;
            String line;

            if (args.length == 2) {
                String language = args[0];
                String country = args[1];
                Locale locale = new Locale(language, country);
                resMan.switchLocale(locale);
            }

            Parser parser = new Parser();
            Printer printer = new Printer();

            while (!(line = scanner.nextLine()).equals("end")) {
                if (line.equals("printvar")) {
                    Var.printVar();
                    continue;
                }
                if (line.equals("en")) {
                    resMan.switchLocale(new Locale("en", "US"));
                    continue;
                }
                if (line.equals("ru")) {
                    resMan.switchLocale(new Locale("ru", "RU"));
                    continue;
                }
                if (line.equals("be")) {
                    resMan.switchLocale(new Locale("be", "BY"));
                    continue;
                }
                try {
                    Var result = parser.calculateExpression(line);
                    printer.print(result);
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
