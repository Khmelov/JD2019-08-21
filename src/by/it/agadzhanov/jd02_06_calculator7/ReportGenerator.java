package by.it.agadzhanov.jd02_06_calculator7;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class ReportGenerator {

    static void generateShort(Report report) {
        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(PathGenerator.dir(ConsoleRunner.class) + "shortReport.txt"))) {
            printWriter.println(report.getTitle());
            printWriter.println(report.getStartTime());
            printWriter.println();
            for (String errorMessage : report.getErrorMessages()) {
                printWriter.println(errorMessage);
            }
            printWriter.println();
            printWriter.println(report.getEndTime());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void generateLong(Report report) {
        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(PathGenerator.dir(ConsoleRunner.class) + "longReport.txt"))) {
            printWriter.println(report.getTitle());
            printWriter.println(report.getStartTime());
            printWriter.println(report.getOperations());
            printWriter.println();
            for (int i = 0; i < report.getErrorMessages().size(); i++) {
                printWriter.println(report.getErrorMessages().get(i));
                for (StackTraceElement stackTraceElement : report.getErrorStackTraces().get(i)) {
                    printWriter.println(stackTraceElement);
                }
                printWriter.println();
            }
            printWriter.println();
            printWriter.println(report.getEndTime());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
