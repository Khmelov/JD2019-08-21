package by.it.zhukovskaya.jd02_05;


import java.util.Locale;
import java.util.ResourceBundle;

public class CheckI18N {
    public static void main(String[] args){
        Locale locale=new Locale("ru","RU");
        String baseName="by.it.zhukovskaya.jd02_05.res.strings";
        ResourceBundle resourceBundle= ResourceBundle.getBundle(baseName,locale);
        String welcome=resourceBundle.getString("message.welcome");
        System.out.println(welcome);

    }
}
