package by.it.kiturka.jd06_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;

public class Logger {
    private static volatile Logger logger;
    private Logger() {

    }

    public static Logger getLogger(){
        Logger lcLogger = logger;
        if (lcLogger == null) {
            synchronized (Logger.class) {
              lcLogger = logger;
              if (lcLogger == null) {
                  logger = lcLogger = new Logger();
              }
            }
        }
        return lcLogger;
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
