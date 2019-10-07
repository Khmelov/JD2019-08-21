package by.it.shamuradova.jd02_05.res;

import java.util.*;

public class CheckI18N {

    public static void main(String[] args) {
        ResMan resourceManager = ResMan.INSTANCE;
        if (args.length == 2) {
            String language = args[0];
            String country = args[1];
            Locale locale = new Locale(language, country);
            resourceManager.setLocale(locale);
        }

        System.out.println(resourceManager.getFormattedDate(new Date()));
        System.out.println(resourceManager.get(Message.WELCOM));
        System.out.println(resourceManager.get(Message.QUESTION));
        System.out.println(resourceManager.get(User.NAME));
        System.out.println(resourceManager.get(User.SURNAME));

        Map<String, Locale> localeMap = new HashMap<>();
        localeMap.put("be", new Locale("be", "BY"));
        localeMap.put("ru", new Locale("ru", "RU"));
        localeMap.put("en", new Locale("en", "US"));

        Scanner sc = new Scanner(System.in);
        while (true) {
            String command = sc.nextLine();
            Locale locale = localeMap.get(command);

            if (locale != null) {
                resourceManager.setLocale(locale);
            }

            System.out.println(resourceManager.getFormattedDate(new Date()));
            System.out.println(resourceManager.get(Message.WELCOM));
            System.out.println(resourceManager.get(Message.QUESTION));
            System.out.println(resourceManager.get(User.NAME));
            System.out.println(resourceManager.get(User.SURNAME));
        }

    }
}
