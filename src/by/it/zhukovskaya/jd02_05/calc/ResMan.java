package by.it.zhukovskaya.jd02_05.calc;

import java.util.Locale;
import java.util.ResourceBundle;

enum ResMan {
    INSTANCE;

    private String baseName;
    private ResourceBundle resourceBundle;
    private Locale locale;

    ResMan() {
        baseName="by.it.zhukovskaya.calc.res.strings";
        setLocale(Locale.getDefault());
    }

    void setLocale(Locale locale){
        this.locale=locale;
        resourceBundle=ResourceBundle.getBundle(baseName,locale);
    }

    String get(String key) {
        return resourceBundle.getString(key);
    }


}
