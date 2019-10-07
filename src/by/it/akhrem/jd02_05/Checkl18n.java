package by.it.akhrem.jd02_05;

import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class Checkl18n {
    public static void main(String[] args) {
        ResMan rs=ResMan.INSTANCE;
        Locale locale=Locale.ENGLISH;
        if (args.length==2) {
            String lang = args[0];
            String country = args[1];
            locale=new Locale(lang,country);
        }
        rs.setLocale(locale);

        System.out.println(rs.get(Message.WELCOME));
        System.out.println(rs.get(Message.QUESTION));
        System.out.println(rs.get(User.FIRST_NAME));
        System.out.println(rs.get(User.LAST_NAME));

        Scanner sc = new Scanner(System.in);
        for (;;) {
            System.out.println(rs.get(Message.SUGGESTION));
            String inStr = sc.nextLine();
            if (inStr.equals("end"))
                break;
            switch (inStr) {
                case("ru"): {locale = new Locale("ru", "RU"); break;}
                case("be"): {locale = new Locale("be", "BY"); break;}
                case("en"): {locale = Locale.ENGLISH; break;}
            }
            rs.setLocale(locale);
            Instant now = Instant.now();
            Date date = Date.from(now);
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
            String strDate = dateFormat.format(date);
            System.out.println(strDate);
        }

    }
}
