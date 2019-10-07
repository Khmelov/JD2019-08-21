package by.it.zavadski.jd02_06;

import java.io.File;

public class PathGenerator {
    static String filesPlace(Class <?> className){
        String path= System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String classDirectory=className.getName().replace(className.getSimpleName(),"").replace(".",File.separator);
        return path+File.separator+classDirectory;
    }
}