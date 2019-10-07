package by.it.akhmelev.jd02_05;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;

public class CheckI18N {

    public static void main(String[] args) {
        Locale locale=Locale.ENGLISH;
        ResourceManager rs=ResourceManager.INSTANCE;
        if (args.length==2) {
            String lang = args[0];
            String country = args[1];
            locale=new Locale(lang,country);
            rs.setLocale(locale);
        }
        System.out.println(rs.get(Message.WELCOME));
        System.out.println(rs.get(Message.QUESTION));
        System.out.println(rs.get(User.FIRST_NAME));
        System.out.println(rs.get(User.LAST_NAME));

        Instant now = Instant.now();
        Date date = Date.from(now);
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL,locale);
        String strDate = dateFormat.format(date);
        System.out.println(strDate);

    }

}
