package by.it.boytsov.jd02_06;

import java.io.File;

public class PathGenerator {

    static String directory(Class<?> cl)
    {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String ClassDirectory = cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path+ClassDirectory;
    }
}
