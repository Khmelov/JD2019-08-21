package by.it.zhukovskaya.jd02_05.calc;

import java.util.Locale;
import java.util.ResourceBundle;

import static java.util.ResourceBundle.getBundle;

public enum ResourceManager {

    INSTANCE;

    private final String baseName = "by.it.zhukovskaya.jd02_05.calc.res.messages";
    private ResourceBundle resourceBundle;
    private Locale locale;

    ResourceManager() {
        locale = Locale.getDefault();
        resourceBundle = ResourceBundle.getBundle(baseName,locale);
    }

    public void switchLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = getBundle(baseName,locale);
    }

    public String getString(String key) {
        return resourceBundle.getString(key);
    }
}
