package by.it.krautsevich.jd02_06;

import java.sql.Date;
import java.text.DateFormat;
import java.time.Instant;
import java.util.Locale;

public class ShortReportMaker extends Reporter {

    private static StringBuilder ErrorsCollection = new StringBuilder() ;
    private static String finTime = "" ;
    private static String startTime = "" ;

    @Override
    public String getReportName() {
        String name = "Отчет о работе калькулятора" ;
        return name;
    }

    @Override
    public String getTimeStart() {
        return startTime ;
    }

    @Override
    public String getTimeFin() {
        return finTime;
    }

    public static void setFinTime() {
        Instant now = Instant.now() ;
        java.util.Date data = Date.from(now);
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
        String strDat = dateFormat.format(data);
        finTime = strDat ;
    }

    public static void setStartTime() {
        Instant now = Instant.now() ;
        java.util.Date data = Date.from(now);
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
        String strDat = dateFormat.format(data);
        strDat = startTime ;
    }

    public static void collectErrors(String message){
        Instant now = Instant.now() ;
        java.util.Date data = Date.from(now);
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG , Locale.getDefault());
        String strDat = dateFormat.format(data);
        ErrorsCollection.append(strDat).append(" - ").append(message).append("\n") ;
    }

    public String getErrors() {
        return ErrorsCollection.toString() ;
    }
}
