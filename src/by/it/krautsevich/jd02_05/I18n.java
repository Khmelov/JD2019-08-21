package by.it.krautsevich.jd02_05;

import java.sql.Date;
import java.text.DateFormat;
import java.time.Instant;
import java.util.Locale;
import java.util.Scanner;

public class I18n {
    public static void main(String[] args) {

        Locale eng_locale = new Locale("en","US");
        Locale locale ;
        ResMan resMan = ResMan.INSTANCE ;

        if (args.length == 2) {
            String language = args[0];
            String country = args[1] ;
            locale = new Locale (language , country) ;
            resMan.setLocale(locale);
        }
        else resMan.setLocale(eng_locale);

        System.out.println(resMan.get(Message.WELCOME));
        System.out.println(resMan.get(Message.QUESTION));
        System.out.println(resMan.get(User.FIRSTNAME));
        System.out.println(resMan.get(User.LASTNAME));
        System.out.println();

        Scanner sc = new Scanner(System.in) ;
        String command;
        Locale myLocale = null;
        for ( ; ; ) {
        command = sc.nextLine() ;

        if (command.equals("by"))
        {myLocale = new Locale("be" , "BY");}
        if (command.equals("ru"))
        {myLocale = new Locale("ru" , "RU");}
        if (command.equals("en"))
        {myLocale = new Locale("en" , "US");}
        if (command.equals("end"))
        {break;}

        Instant now = Instant.now() ;
        java.util.Date data = Date.from(now);
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG , myLocale);
        String strDat = dateFormat.format(data);
        System.out.print(strDat);
        System.out.println();
        resMan.setLocale(myLocale);
            System.out.println(resMan.get(Message.WELCOME));
            System.out.println(resMan.get(Message.QUESTION));
            System.out.println(resMan.get(User.FIRSTNAME));
            System.out.println(resMan.get(User.LASTNAME));
            System.out.println();

        }





    }
}
