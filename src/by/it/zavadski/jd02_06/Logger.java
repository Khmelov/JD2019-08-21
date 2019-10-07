package by.it.zavadski.jd02_06;

import by.it.zavadski.calc.Printer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;


public class Logger {
    private static String filename="log.txt";
    private static String path=PathGenerator.filesPlace(Logger.class);
    private static String fullPath=path+ File.separator+filename;

    private static volatile Logger logger;

    public Logger() {
    }

    public static Logger getLogger() {
        if (logger == null) synchronized (Logger.class) {
            if (logger == null) logger = new Logger();
        }
        return logger;
    }

    static void log(String message){
        try(PrintWriter printWriter=new PrintWriter(new FileWriter(fullPath,true))){
            printWriter.println("LOG:"+message);
            printWriter.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}