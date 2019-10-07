package by.it.yuntsevich.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

enum ResourceManager {
    INSTANCE;

    private String baseName;
    private ResourceBundle resourceBundle;


    ResourceManager() {
        baseName = "by.it.yuntsevich.jd02_05.resources.text";
        setLocale(Locale.getDefault());
       }

    void setLocale (Locale locale){
        resourceBundle = ResourceBundle.getBundle(baseName,locale);
    }

     String get(String key) {
        return resourceBundle.getString(key);
    }
}
