package by.it.daletski.jd02_05;

import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class CheckI18N {

    public static void main(String[] args) {
        System.out.println ("Введите требуемый язык из предложенных (en,ru,be): ");
        Locale locale = getLocale ();
        ResourceManager rs = ResourceManager.INSTANCE;
        rs.setLocale (locale);
//        if (args.length == 2) {
//            String lang = args[0];
//            String country = args[1];
//            locale = new Locale (lang, country);
//            rs.setLocale (locale);
//        }
      //  Locale.setDefault (locale);
        System.out.println (rs.get (Message.WELCOME));
        System.out.println (rs.get (Message.QUESTION));
        System.out.println (rs.get (User.FIRST_NAME));
        System.out.println (rs.get (User.LAST_NAME));

        Instant now = Instant.now ();
        Date date = Date.from (now);
        DateFormat dateFormat = DateFormat.getDateInstance (DateFormat.FULL, locale);
        String strDate = dateFormat.format (date);
        System.out.println (strDate);

    }

    private static Locale getLocale() {
        Locale locale = Locale.getDefault ();
        Scanner sc = new Scanner (System.in);
        String parameter = sc.nextLine ();
        switch (parameter) {
            case "ru": {
                locale = new Locale ("ru", "RU");
                return locale;
            }
            case "en": {
                locale = new Locale ("en", "EN");
                return locale;
            }
            case "be": {
                locale = new Locale ("be", "BY");
                return locale;
            }
        }
        return locale;
    }


}