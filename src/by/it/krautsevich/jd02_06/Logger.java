package by.it.krautsevich.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.time.Instant;
import java.util.Locale;

class Logger {

    private static String path = getPath.getMyPath(Logger.class) ;
    private static String filename = "log.txt" ;
    private static String fullpath = path + filename ;

    private Logger() {}

    private static volatile Logger logger;

    static Logger getLogger() {
        Logger loggerLocal = logger ;
        if (loggerLocal == null){
            synchronized (Logger.class) {
        if (logger == null) {
            logger = new Logger() ;
            loggerLocal = logger ; }
            }
        }
        return loggerLocal ;
    }

    synchronized void log(String message) {
        try (PrintWriter printer = new PrintWriter(new FileWriter(fullpath, true)) ) {
            Instant now = Instant.now() ;
            java.util.Date data = Date.from(now);
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG , Locale.getDefault());
            String strDat = dateFormat.format(data);

            printer.println("LOG:(" + strDat + ") " + message);
            printer.flush();
    } catch (IOException e) {
            e.printStackTrace();}
    }
}
