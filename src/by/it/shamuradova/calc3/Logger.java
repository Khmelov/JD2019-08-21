package by.it.shamuradova.calc3;

import by.it.shamuradova.calc3.creationOtchet.Report;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

public class Logger {

    private static volatile Logger instance;
    private String filename;

    private Logger() {}



    //метод доступа к экземпляру
    public static Logger getInstance() {
        Logger logger = instance;
        if (logger == null) {
            synchronized (Logger.class) {
                logger = instance;
                if (logger == null) {
                    instance = logger = new Logger();
                }
            }
        }
        return logger;
    }

    private static String getPath(Class<?> clazz) {
        String rootProject = System.getProperty("user.dir"); //C:\Users\Бегенч\IdeaProjects\JD2019-08-21
        String subPath = clazz.getName().replace(".", File.separator).replace(clazz.getSimpleName(), ""); //by\it\shamuradova\jd02_06\
        String path = rootProject + File.separator + "src" + File.separator + subPath; //C:\Users\Бегенч\IdeaProjects\JD2019-08-21\src\by\it\shamuradova\jd02_06\
        return path;
    }

    void writeShortReport(Report report) {
        String path = getPath(Logger.class);
        filename = path + "shortReport.txt";

        try (PrintWriter pw = new PrintWriter(new FileWriter(filename, true))) {
            pw.println(report.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeFullReport(Report report) {
        String path = getPath(Logger.class);
        filename = path + "fullReport.txt";

        try (PrintWriter pw = new PrintWriter(new FileWriter(filename, true))) {
            pw.println(report.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeInFile(String messageAboutMistake) {
        String path = getPath(Logger.class);
        filename = path + "log.txt";

        try (PrintWriter pw = new PrintWriter(new FileWriter(filename, true))) {
            Date date = new Date();
            String formatDate = DateFormat.getDateInstance(DateFormat.LONG).format(date);
            pw.println(formatDate + messageAboutMistake);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
