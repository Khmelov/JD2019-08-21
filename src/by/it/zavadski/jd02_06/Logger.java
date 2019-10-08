package by.it.zavadski.jd02_06;

import by.it.zavadski.calc.Printer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Logger {
    private static String filename="log.txt";
    private static String path=PathGenerator.filesPlace(Logger.class);
    private static String fullPath=path+ File.separator+filename;

    private static volatile Logger logger;

    public Logger() {
    }

    public static Logger getLogger() {
        Logger localLogger=logger;
        if (localLogger == null)
            synchronized (Logger.class) {
            localLogger=logger;
            if (localLogger == null)
                localLogger = new Logger();
            logger=localLogger;
        }
        return localLogger;
    }

    static void log(String message){
        try(PrintWriter printWriter=new PrintWriter(new FileWriter(fullPath,true))){
            DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy HH/mm");
            //printWriter.println("LOG:"+message);
            printWriter.printf("%s: %s\n",dateFormat.format(new Date()),message);
            //printWriter.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}