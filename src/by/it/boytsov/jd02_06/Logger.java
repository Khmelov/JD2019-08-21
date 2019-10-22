package by.it.boytsov.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static String filename = "log.txt";
    private static  String path = PathGenerator.directory(Logger.class);
    private static String fullpath = path+filename;

    private Logger(){}

    private static volatile Logger logger;

    static Logger getLogger()
    {
        Logger loggerlocal = logger;
        if(loggerlocal == null)
        {
            logger=new Logger();
            loggerlocal=logger;
        }
        return loggerlocal;
    }
    synchronized void LogInfo(String message)
    {
        try (PrintWriter printWriter=new PrintWriter(new FileWriter(fullpath,true)))
        {
            printWriter.println(message);
            printWriter.flush();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
