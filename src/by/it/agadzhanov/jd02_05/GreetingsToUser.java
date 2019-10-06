package by.it.agadzhanov.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class GreetingsToUser {

    public static void main(String[] args) throws Exception {
        ResourceManager resMan = ResourceManager.INSTANCE;
        if (args.length == 2) {
            String language = args[0];
            String country = args[1];
            Locale locale = new Locale(language, country);
            resMan.switchLocale(locale);
        }

        System.out.println(resMan.getString(Message.WELCOME));
        System.out.println(resMan.getString(Message.QUESTION));
        System.out.println(resMan.getString(User.FIRSTNAME));
        System.out.println(resMan.getString(User.LASTNAME));

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, resMan.getLocale());
        System.out.println(dateFormat.format(new Date()));

        Scanner scanner = new Scanner(System.in);
        String command;
        while (!(command = scanner.nextLine()).equals("end")) {
            switch (command) {
                case "ru":
                    resMan.switchLocale(new Locale("ru", "RU"));
                    break;
                case "be":
                    resMan.switchLocale(new Locale("be", "BY"));
                    break;
                case "en":
                    resMan.switchLocale(new Locale("en", "US"));
                    break;
                default:
                    throw new Exception("Запрашиваемый язык не найден!");
            }
            dateFormat = DateFormat.getDateInstance(DateFormat.FULL, resMan.getLocale());
            System.out.println(resMan.getString(Message.WELCOME));
            System.out.println(resMan.getString(Message.QUESTION));
            System.out.println(resMan.getString(User.FIRSTNAME));
            System.out.println(resMan.getString(User.LASTNAME));
            System.out.println(dateFormat.format(new Date()));
        }
    }
}
