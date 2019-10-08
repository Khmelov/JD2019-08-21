package by.it.agadzhanov.jd02_06_calculator7;

import java.io.File;

class PathGenerator {

    static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }
}
