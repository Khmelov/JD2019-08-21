package by.it.rojas.jd20.res;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;
    private String baseName;
    private ResourceBundle resourceBundle;
    private Locale locale;

    ResMan() {
        baseName = "by.it.rojas.jd20.res.strings";
        setLocale(Locale.getDefault());
    }

    void setLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(baseName, locale);

    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }

    public String getFormattedDate(Date date) {
        return DateFormat.getDateInstance(DateFormat.LONG, this.locale).format(date);
    }
}
