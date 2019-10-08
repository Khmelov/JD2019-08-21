package by.it.yuntsevich.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

class Logger {

    private static DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.getDefault());
    private static String filename = getPath() + "log.txt";

    private Logger() {
    }

    private static volatile Logger logger;

    static Logger getLogger() {
        Logger log = logger;
        if (log == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                    log = logger;
                }
            }
        }
        return log;

    }

    synchronized void toLog(String message) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename, true))) {
            printWriter.println(message + " " + dateFormat.format(new Date()) + "\n");
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath() {
        String root = System.getProperty("user.dir");
        String name = Logger.class.getName();
        String simpleName = Logger.class.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }
}
