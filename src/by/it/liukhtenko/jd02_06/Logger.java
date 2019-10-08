package by.it.liukhtenko.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {
     private static String filename = "log.txt";
     private static  String path = PathGenerator.getPath(Logger.class);
     private static String fullpath = path+filename;

    private Logger() {
    }

     private static volatile Logger logger ;

      static   Logger getLogger() {
         Logger loggerlocal = logger;
          if (loggerlocal == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                    loggerlocal = logger;
                }
           }
         }
          return loggerlocal;
      }
     synchronized void log (String message){
         try (PrintWriter printWriter=
                      new PrintWriter(
                              new FileWriter(fullpath,true)
                      )
         ){
            printWriter.println("LOG:"+ message);
            printWriter.flush();
         } catch (IOException e) {
             e.printStackTrace();
         }
      }
}
