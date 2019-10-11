package by.it.shamuradova.calc3;

import by.it.shamuradova.calc3.creationOtchet.Report;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        ResManager rm = ResManager.INSTANCE;
        Logger logger = Logger.getInstance();

        Report.ReportBuilder shortReportBuilder = Report.builder();
        Report.ReportBuilder fullReportBuilder = Report.builder();
        for (; ; ) {
            String out = rm.getKey(Message.ENTER);
            System.out.println(out);
            String vyragenie = sc.nextLine();

            shortReportBuilder.withOperation(vyragenie).withHeader(Report.OPERATION_HEADER);
            fullReportBuilder.withOperation(vyragenie).withHeader(Report.OPERATION_HEADER);
            try {
                if (vyragenie.equals("end")) {
                    break;
                }
                if (vyragenie.equals("printvar")) {
                    printer.printMap(Creator.getVars());
                }
                if (vyragenie.equals("sortvar")) {
                    printer.printSorted(Creator.getVars());
                }
                if (vyragenie.equals("ru")) {
                    rm.setLocale(new Locale("ru", "RU"));
                }
                if (vyragenie.equals("be")) {
                    rm.setLocale(new Locale("be", "BY"));
                }
                if (vyragenie.equals("en")) {
                    rm.setLocale(new Locale("en", "US"));
                }
                else{
                    Var result = parser.calc(vyragenie);
                    printer.print(result);
                }

            } catch (CalcException e) {
                System.out.println(e.getMessage());
                shortReportBuilder.withHeader(Report.ERROR_HEADER).withShortErrorMessage(e);
                fullReportBuilder.withHeader(Report.ERROR_HEADER).withFullErrorMessage(e);
            } finally {
                shortReportBuilder.withDate(new Date());
                fullReportBuilder.withDate(new Date());
                logger.writeShortReport(shortReportBuilder.build());
                logger.writeFullReport(fullReportBuilder.build());
            }
        }
    }
}
