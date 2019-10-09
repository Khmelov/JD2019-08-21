package by.it.shamuradova.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

public class Logger {

    private static volatile Logger instance;
    String filename;

    private Logger(){};

    //метод доступа к экземпляру
    public static Logger getInstance(){
        Logger logger = instance;
        if(logger==null){
            synchronized (Logger.class){
                logger = instance;
                if(logger==null){
                    instance=logger=new Logger();
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
    void writeInFile(String errorMessage){
        String path = getPath(Logger.class);
        filename=path + "log.txt";

        try(PrintWriter pw = new PrintWriter(new FileWriter(filename, true))){
            Date date = new Date();
            String formatDate = DateFormat.getDateInstance(DateFormat.LONG).format(date);
            pw.println(formatDate + errorMessage);
        }catch(IOException e ){
            e.printStackTrace();
        }
    }
}
