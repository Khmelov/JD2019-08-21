package by.it.krautsevich.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {

    MY_MANAGER;


    private final String baseName = "by.it.krautsevich.test.res.strings";
    private ResourceBundle resourceBundle;
    private Locale locale;

    ResourceManager() {
        locale = Locale.getDefault();
        resourceBundle = ResourceBundle.getBundle(baseName,locale);
    }

    public void switchLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(baseName,locale);
    }

    public Locale getLocale() {
        return locale;
    }

    public String getString(String key) {
        return resourceBundle.getString(key);
    }
}
