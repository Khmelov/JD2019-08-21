package by.it.krautsevich.jd02_05;

import java.sql.Date;
import java.text.DateFormat;
import java.time.Instant;
import java.util.Locale;

public class TaskA {
    public static void main(String[] args) {

        Locale locale = Locale.ENGLISH;
        Locale eng_locale = Locale.ENGLISH ;
        ResMan resMan = ResMan.INSTANCE ;

        if (args.length == 2) {
            String language = args[0];
            String country = args[1] ;
            locale = new Locale (language , country) ;
            resMan.setLocale(locale);
        }
        else resMan.setLocale(eng_locale);
        resMan.setLocale(Locale.ENGLISH);


        System.out.println(resMan.get(Message.WELCOME));
        System.out.println(resMan.get(Message.QUESTION));
        System.out.println(resMan.get(User.FIRSTNAME));
        System.out.println(resMan.get(User.LASTNAME));

        Instant now = Instant.now() ;
        java.util.Date data = Date.from(now);
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG , locale);
        String strDat = dateFormat.format(data);
        System.out.print(strDat);





    }
}
