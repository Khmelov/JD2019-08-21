package by.it.liukhtenko.jd02_05;

import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;

public class Checki18nNew {

    public static void main(String[] args) {
        Locale locale = Locale.ENGLISH;
        ResourseManager rs =ResourseManager.INSTANCE;
        if(args.length==2){
            String lang = args[0];
            String country = args[1];
            locale = new Locale(lang,country);
            rs.setLocale(locale);
        }
        Locale.setDefault(locale);
        ResourseManager.INSTANCE.setLocale(Locale.ENGLISH);
        System.out.println(rs.get(Message.WELCOME));
        System.out.println(rs.get(Message.QUESTION));
        System.out.println(rs.get(User.FIRST_NAME));
        System.out.println(rs.get(User.SECOND_NAME));

        Instant now = Instant.now();
        Date date = Date.from(now);
        DateFormat dateformat = DateFormat.getDateInstance(DateFormat.LONG,Locale.getDefault() );
        String strDate = dateformat.format(date);
        System.out.println(strDate);

    }
}
