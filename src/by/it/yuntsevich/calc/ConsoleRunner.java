package by.it.yuntsevich.calc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    static Date start;
    static Date finish;

    private static String getFileName(String name) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = ConsoleRunner.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + name;
    }

    public static void main(String[] args) {
        ConsoleRunner.start = new Date();
        Logger logger = Logger.getLogger();
        try {
            VarFactory.load();
            logger.loadLogs();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        VarFactory.readVars();
        ResourceManager manager = ResourceManager.INSTANCE;
        Locale.setDefault(Locale.ENGLISH);

        try (BufferedWriter bw = new BufferedWriter
                (new FileWriter(ConsoleRunner.getFileName("operationsAndResults.txt")))) {
            for (; ; ) {
                String expression = sc.nextLine();
                bw.append('\n');
                bw.append(expression);
                bw.append('\n');
                if (expression.equals("end")) break;
                if (expression.equals("printvar")) {
                    printer.printMap(VarFactory.getVars());
                    continue;
                }
                if (expression.equals("sortvar")) {
                    printer.printSorted(VarFactory.getVars());
                    continue;
                }
                if (expression.equals("en")) {
                    manager.setLocale(Locale.ENGLISH);
                    continue;
                }
                if (expression.equals("ru")) {
                    manager.setLocale(new Locale("ru", "RU"));
                    continue;
                }
                if (expression.equals("be")) {
                    manager.setLocale(new Locale("be", "BY"));
                    continue;
                }
                try {
                    Var result = parser.calc(expression);
                    bw.append(result.toString());
                    if (result != null) printer.print(result);
                } catch (CalcException e) {
                    logger.toLog(e.getMessage());
                    bw.append(e.toString());
                    System.out.println(e.getMessage());
                }
//                catch (CalcException e) {
//                    System.out.println(e.getMessage());
//                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        ConsoleRunner.finish = new Date();
        Constructor constructor = new Constructor();
        ReportBuilder reportBuilder = Math.random() > 0.5 ? new ShortReportBuilder() : new FullReportBuilder();
        constructor.setReportBuilder(reportBuilder);
        constructor.constructReport();
        Report report = constructor.getReport();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(ConsoleRunner.getFileName("report.txt")))){
            bw.write(report.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(report);


    }
    }


