package by.it.krautsevich.jd02_06;

import java.io.File;

public class getPath {

    public static String getMyPath(Class<?> getClass) {
        String rootProject = System.getProperty("user.dir") ;
        String subPaths = getClass.getName().replace("." , File.separator).
                replace(getClass.getSimpleName() , "") ;
        String path = rootProject + File.separator+ "src" + File.separator + subPaths ;
        return path ; }

    public static void main(String[] args) {
        String s = getMyPath(getPath.class) ;
        System.out.println(s);
    }
}
