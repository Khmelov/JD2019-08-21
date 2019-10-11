package by.it.yakimovich.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
                    logger = new Logger();
                    loggerLocal = logger;
                }
            }
        }
        return loggerLocal;


    }
    synchronized void log (String message){
        try (PrintWriter printWriter =
                     new PrintWriter (
                             new FileWriter (fullpath, true))
        ) {
            printWriter.println ("LOG:" + message);
            printWriter.flush ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}