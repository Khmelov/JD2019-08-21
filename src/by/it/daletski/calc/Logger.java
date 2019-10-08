package by.it.daletski.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;

class Logger {

    private static String filename = "log.txt";
    private static String path = PathGenerator.getPath (Logger.class);
    private static String fullpath = path + filename;

    private Logger() {

    }

    private static volatile Logger logger;

    static Logger getLogger() {
        Logger loggerLocal = logger;
        if (loggerLocal == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger ();
                    loggerLocal = logger;
                }
            }
        }
        return loggerLocal;


    }
    public void writeStr(String str){
        String path = getPath(Logger.class);
        String filename = path + "log.txt";
        Instant now = Instant.now();
        Date date = Date.from(now);
        DateFormat dateFormat = DateFormat.getDateTimeInstance();//(DateFormat.LONG, Locale.getDefault());
        String strDate = dateFormat.format(date);
        try (PrintWriter outF = new PrintWriter(new FileWriter(filename, true))){
            outF.printf("\n%s: %s", strDate, str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath(Class<?> taskAClass) {
        String rootProject = System.getProperty("user.dir");
        String subPath = taskAClass.getName().replace(".", File.separator).replace(taskAClass.getSimpleName(), "");
        String path = rootProject + File.separator + "src" + File.separator + subPath;
        return path;
    }
}