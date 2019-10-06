package by.it.zavadski.jd01_15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.SimpleTimeZone;

/**
 * Класс TaskC Нужно реализовать на java приложение - аналог командной строки Windows. Приложение должно
 * использовать класс File и поддерживать две команды консоли:
 *  команду cd - смена каталога
 *  команду dir - вывод каталога, формат вывода - аналогичный формату в Windows.
 *  команда end – завершение работы.
 *  Стартовым каталогом при запуске приложения должна быть папка by.it.ваша_фамилия.jd01_15.
 */

public class TaskC {
    private static StringBuilder defaulttDir=new StringBuilder(getClassPath(TaskC.class));
    private static File defDir=new File(defaulttDir.toString());

    private static String getClassPath(Class <?> className){
        String path= System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String packagePath=className.getPackage().getName().replace(".",File.separator);
        return path+packagePath;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputKey;
        while(!(inputKey=scanner.nextLine()).equals("end")){
            StringBuilder cmd=new StringBuilder(inputKey);
            changeDirectory(cmd);
        }
    }

    private static void changeDirectory(StringBuilder input) {
        if(!input.toString().contains(" ")) input.append(" ");
        String[] commands=input.toString().split(" ",2);
        if(commands[0].equals("cd")&&commands[1].equals("..")){
            String parentDir=defDir.getParent();
            defDir= new File(parentDir);
            System.out.println(defDir.getAbsolutePath());
        }
        else{
            String newPath=defDir.getAbsolutePath()+File.separator+commands[1];
            File tFile=new File(newPath);
            if(tFile.exists()){
                defDir=new File(newPath);
                System.out.println(defDir.getAbsolutePath());
                }else System.out.println("Incorrect path: "+newPath);
            }
        if(commands[0].equals("dir")&&(commands[1].isEmpty()|commands[1].equals(""))){
            File[] files=defDir.listFiles();
            if(files!=null){
                for (File element : files) {
                    SimpleDateFormat data=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    if(element.isFile()){
                        long totalSpace=element.getTotalSpace();
                        System.out.printf("%-20s\t%-10d\t%-20s",data.format(element.lastModified()),totalSpace,element.getName());
                        System.out.println();
                    }else{
                        System.out.printf("%-20s\t%-10s\t\t%-20s",data.format(element.lastModified()),"<DIR>",element.getName());
                        System.out.println();
                    }
                }
            }
    }

    }

}
