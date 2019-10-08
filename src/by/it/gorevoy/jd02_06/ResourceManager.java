package by.it.gorevoy.jd02_06;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {

    INSTANCE;

    private final String baseName = "by.it.gorevoy.jd02_05.res.messages";
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

    public String getString(String key) {
        return resourceBundle.getString(key);
    }
}