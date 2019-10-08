package by.it.zlotnikova.jd02_06;

import java.io.File;

public class PathGenerator {

    static String getPath(Class<?> clazz) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String subPath = clazz.getName().replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return path + subPath;

    }
}