package by.it.yuntsevich.calc;

import java.io.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

class Logger {

    private static DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.getDefault());
    private static String filename = getPath() + "log.txt";
    private static StringBuilder sb = new StringBuilder();


    private Logger() {
    }

    private static volatile Logger logger;

    static Logger getLogger() {
        Logger log = logger;
        if (log == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                    log = logger;
                }
            }
        }
        return log;

    }

    static synchronized void toLog(String message) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename, true))) {
            printWriter.println(message + " " + dateFormat.format(new Date()) + "\n");
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String getFileName() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = Logger.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + "log.txt";
    }
    private static String getPath() {
        String root = System.getProperty("user.dir");
        String name = Logger.class.getName();
        String simpleName = Logger.class.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }

    void loadLogs(){
        File file = new File(getFileName());
        if (file.exists()) {
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    sb.append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
