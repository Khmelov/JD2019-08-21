package by.it.agadzhanov.jd02_06_calculator7;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class Logger {

    private static Logger instance;

    private Logger() {
    }

    static Logger getInstance() {
        Logger localInstance = instance;
        //Проверка для скорости
        if (localInstance == null) {
            localInstance = new Logger();
            instance = localInstance;
        }
        return localInstance;
    }

    void printErrorInfo(String message) {
        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(
                        PathGenerator.dir(Logger.class) + "log.txt", true))) {
            printWriter.println(message);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH/mm/ss");
            Date date = new Date();
            printWriter.println(dateFormat.format(date));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
