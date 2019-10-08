package by.it.gorevoy.jd02_06;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ConsoleRunner {
    public static void main(String[] args) {
        String title = "ConsoleRunner class Report (Calculator project)";
        DateFormat startDateFormat = new SimpleDateFormat("dd/MM/yyyy HH/mm/ss");
        String startTime = "Start of program execution: " + startDateFormat.format(new Date());
        Scanner scanner = new Scanner(System.in);
        ResourceManager resMan = ResourceManager.INSTANCE;
        Logger logger = Logger.getInstance();
        String line;
        int commandCount = 0;
        StringBuilder operations = new StringBuilder();
        List<String> errorMessages = new ArrayList<>();
        List<StackTraceElement[]> errorStackTraces = new ArrayList<>();


        if (args.length == 2) {
            String language = args[0];
            String country = args[1];
            Locale locale = new Locale(language, country);
            resMan.switchLocale(locale);
        }

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = scanner.nextLine()).equals("end")) {
            commandCount++;
            operations.append("\n").append(commandCount).append(".  ").append(line);
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
                operations.append("\n").append(commandCount).append(".  ").append(result);
            } catch (CalculationException e) {
                System.out.println(e.getMessage());
                logger.printErrorInfo(e.getMessage());
                errorMessages.add(e.getMessage() + " at command " + commandCount + " at line "
                        + e.getStackTrace()[0].getLineNumber() + " of class " + e.getStackTrace()[0].getClassName());
                errorStackTraces.add(e.getStackTrace());
            }
        }

        operations.append("\n").append(++commandCount).append(".  ").append(line);

        DateFormat endDateFormat = new SimpleDateFormat("dd/MM/yyyy HH/mm/ss");
        String endTime = "End of program execution: " + endDateFormat.format(new Date());

        //Краткий отчет
        Report shortReport = new Report.ReportBuilder(title, startTime, endTime, errorMessages).build();
        ReportGenerator.generateShort(shortReport);

        //Полный отчет
        Report longReport = new Report.ReportBuilder(title, startTime, endTime, errorMessages).
                operations(operations).errorStackTraces(errorStackTraces).build();
        ReportGenerator.generateLong(longReport);
    }
}