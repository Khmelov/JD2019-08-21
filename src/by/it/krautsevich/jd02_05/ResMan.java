package by.it.krautsevich.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;

    private String reference  ;
    private ResourceBundle res_Boundle ;
    private Locale locale ;

    ResMan() {
        reference= "by.it.krautsevich.jd02_05.res.strings" ;
        setLocale(Locale.getDefault());
    }

    void setLocale(Locale locale) {
        this.locale=Locale.getDefault();
        res_Boundle=ResourceBundle.getBundle(reference, locale) ;
    }

    void setLocale(String language , String country) {
        locale = new Locale (language , country) ;
        setLocale(locale);
    }

    String get(String key) {
        return res_Boundle.getString(key) ;
    }

    Locale getLocale() {
        return locale;
    }
}
