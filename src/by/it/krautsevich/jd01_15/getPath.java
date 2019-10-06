package by.it.krautsevich.jd01_15;

import java.io.File;

public class getPath {

    public static String getMyPath(Class<?> getClass) {
        String rootProject = System.getProperty("user.dir") ;
        String subPaths = getClass.getName().replace("." , File.separator).
                replace(getClass.getSimpleName() , "") ;
        String path = rootProject + File.separator+ "src" + File.separator + subPaths ;
        return path ; }
}
