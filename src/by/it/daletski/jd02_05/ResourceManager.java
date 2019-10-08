package by.it.daletski.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {

    INSTANCE;

    private String baseName;
    private ResourceBundle resourceBundle;
    private Locale locale;

    ResourceManager() {
        baseName = "by.it.daletski.jd02_05.res.strings";
        setLocale (Locale.getDefault ());
    }

    void setLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle (baseName, locale);

    }

    public String get(String key) {
        return resourceBundle.getString (key);
    }
}
