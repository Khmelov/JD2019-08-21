package by.it.liukhtenko.jd02_05;

import java.io.IOException;
import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Checki18n {

    public static void main(String[] args) throws IOException {
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

        System.out.println("input: \n"+"ru RU\n" +"be BY \n"+"en EN");
        Scanner sc = new Scanner(System.in);
        String input;
        input= sc.nextLine();
        while (!(input.equals("end"))){
            String[] params = input.split(" ");
            if (params.length == 2) {
                String lang = params[0];
                String country = params[1];
                locale = new Locale(lang, country);
                rs.setLocale(locale);
                System.out.println(rs.get(Message.WELCOME));
                System.out.println(rs.get(Message.QUESTION));
                System.out.println(rs.get(User.FIRST_NAME));
                System.out.println(rs.get(User.SECOND_NAME));
                dateformat = DateFormat.getDateInstance(DateFormat.LONG,locale );
                strDate = dateformat.format(date);
                System.out.println(strDate);
                break;
            } else {
                throw new IOException("Incorrect input!");
            }
        }
    }
}
