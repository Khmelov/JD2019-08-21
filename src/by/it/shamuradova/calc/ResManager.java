package by.it.shamuradova.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResManager {
    INSTANCE;
    private String baseName;
    private ResourceBundle rb;
    Locale locale;

    ResManager() {
        baseName = "by.it.shamuradova.calc.res.strings";
        setLocale(Locale.getDefault());
    }

    void setLocale(Locale local) {
        this.locale=local;
        rb=ResourceBundle.getBundle(baseName, locale);
    }
    String getKey(String key){
        String keys = rb.getString(key);
        return keys;
    }
}








