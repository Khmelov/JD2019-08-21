package by.it.yuntsevich.jd02_05;

import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class CheckI18N {

    public static void main(String[] args) {
        Locale locale = Locale.ENGLISH;
        Locale.setDefault(Locale.ENGLISH);
        ResourceManager rs = ResourceManager.INSTANCE;
        if (args.length == 2) {
            String lang = args[0];
            String country = args[1];
            locale = new Locale(lang, country);
            rs.setLocale(locale);
        }
        System.out.println(rs.get(Message.WELCOME));
        System.out.println(rs.get(Message.QUESTION));
        System.out.println(rs.get(User.NAME));
        System.out.println(rs.get(User.SURNAME));

        Instant now = Instant.now();
        Date date = Date.from(now);
        DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.FULL, locale);
        String strDate = dateInstance.format(date);

        System.out.println(strDate);


        //TaskB
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        switch (line) {
            case "ru":
                locale = new Locale("ru", "RU");
                rs.setLocale(locale);
                dateInstance = DateFormat.getDateInstance(DateFormat.FULL, locale);
                strDate = dateInstance.format(date);

                System.out.println(rs.get(Message.WELCOME));
                System.out.println(rs.get(Message.QUESTION));
                System.out.println(rs.get(User.NAME));
                System.out.println(rs.get(User.SURNAME));
                System.out.println(strDate);

                break;
            case "be":
                locale = new Locale("be", "BY");
                rs.setLocale(locale);

                dateInstance = DateFormat.getDateInstance(DateFormat.FULL, locale);
                strDate = dateInstance.format(date);

                System.out.println(rs.get(Message.WELCOME));
                System.out.println(rs.get(Message.QUESTION));
                System.out.println(rs.get(User.NAME));
                System.out.println(rs.get(User.SURNAME));
                System.out.println(strDate);

                break;
            case "en":
                locale = new Locale("en", "US");
                rs.setLocale(locale);

                System.out.println(rs.get(Message.WELCOME));
                System.out.println(rs.get(Message.QUESTION));
                System.out.println(rs.get(User.NAME));
                System.out.println(rs.get(User.SURNAME));
                dateInstance = DateFormat.getDateInstance(DateFormat.FULL, locale);
                strDate = dateInstance.format(date);
                System.out.println(strDate);
                break;
        }
    }
}

