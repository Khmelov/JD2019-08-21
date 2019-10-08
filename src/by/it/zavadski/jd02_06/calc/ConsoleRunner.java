package by.it.zavadski.jd02_06.calc;

import by.it.zavadski.jd02_05.ResourceManager;
import by.it.zavadski.jd02_06.Logger;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static ResourceManager resourceManager=ResourceManager.INSTANCE;

    public static void main(String[] args) throws CalcException {
        Scanner scanner = new Scanner(System.in);
        String line;

        if (args.length==2){
            String lang=args[0];
            String country=args[1];
            Locale locale=new Locale(lang,country);
            resourceManager.setLocale(locale);
        }
        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = scanner.nextLine()).toLowerCase().equals("end")) {
            if (line.equals("prv")) {
                Logger.log("prv: ");
                Var.printVar();
                continue;
            }
            if (line.equals("en")) {
                resourceManager.setLocale(new Locale("en", "US"));
                Logger.log("Locale changed to en-US");
                continue;
            }
            if (line.equals("ru")) {
                resourceManager.setLocale(new Locale("ru", "RU"));
                Logger.log("Locale changed to ru-RU");
                continue;
            }
            if (line.equals("be")) {
                resourceManager.setLocale(new Locale("be", "BY"));
                Logger.log("Locale changed to be-BY");
                continue;
            }
            try {
                Var result = parser.calculate(line);
                printer.print(result);
                Logger.log(result.toString());
            } catch (CalcException e) {
                System.out.println(e.getMessage());
                Logger.log(e.getMessage());
            }
        }
    }
}
