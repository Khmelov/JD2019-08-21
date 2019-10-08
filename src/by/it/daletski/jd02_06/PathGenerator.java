package by.it.daletski.jd02_06;

import java.io.File;

public class PathGenerator {

    static String getPath(Class<?> taskAClass) {
        String rootPtoject = System.getProperty ("user.dir");
        String subPath = taskAClass.getName ().replace (".", File.separator).replace (taskAClass.getSimpleName (), "");
        return rootPtoject + File.separator + "src" + File.separator + subPath;
    }


}
