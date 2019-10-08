package by.it.zlotnikova.jd02_05;

import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class CheckI18N {
    public static void main(String[] args) {
        Locale locale = getLocale();
        ResourceManager rm = ResourceManager.INSTANCE;
        rm.setLocale(locale);
//        if (args.length == 2) {
//            String language = args[0];
//            String country = args[1];
//            locale = new Locale(language, country);
//            rm.setLocale(locale);
//        }

        System.out.println(rm.get(Message.WELCOME));
        System.out.println(rm.get(Message.QUESTION));
        System.out.println(rm.get(User.FIRST_NAME));
        System.out.println(rm.get(User.LAST_NAME));

        Instant now = Instant.now();
        Date date = Date.from(now);
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
        String strDate = dateFormat.format(date);
        System.out.println(strDate);
    }

    private static Locale getLocale() {
        Locale locale = Locale.getDefault();
        Scanner sc = new Scanner(System.in);
        String parameter = sc.nextLine();
        switch (parameter) {
            case "ru": {
                locale = new Locale("ru", "RU");
                return locale;
            }
            case "en": {
                locale = new Locale("en", "EN");
                return locale;
            }
            case "be": {
                locale = new Locale("be", "BY");
                return locale;
            }
        }
        return locale;
    }
}
