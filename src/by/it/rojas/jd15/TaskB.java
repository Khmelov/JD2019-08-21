package by.it.rojas.jd15;

import java.io.*;

public class TaskB {
    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {
        //comment1
        //comment2
        /*comment
        uhuhu
        number3*/
        /*comment
        number4*/
        /**
         This is a JavaDoc class comment*/
        StringBuilder sb = new StringBuilder();
        String filename = dir(TaskB.class).concat(TaskB.class.getSimpleName()+".txt");
        File f = new File(filename);
        int b;

        try (BufferedReader is = new BufferedReader(new FileReader(dir(TaskB.class).
                concat(TaskB.class.getSimpleName()+".java")));
             PrintWriter out  = new PrintWriter (new FileWriter(filename)))
        {
            String res = is.readLine();
            int needprint = 0;

            while (res !=null){
                if (res.contains("//")){
                    int index = res.indexOf("/");
                    res = res.substring(0,index);
                    System.out.println(res);
                    out.println(res);
                }
                else if ((res.contains("/") && res.length() != res.indexOf("/")+1 && res.charAt(res.indexOf("/")+1) == '*'
                        && !res.contains("if")  && res.length() != res.indexOf("/")+2 && res.charAt(res.indexOf("/")+2) != '*'))
                {
                    needprint++;
                    int index = res.indexOf("*");
                    res = res.substring(0,index-1);
                    System.out.println(res);
                    out.println(res);
                }
                else if ((res.contains("/") && res.length() != res.indexOf("/")+1 && res.length() != res.indexOf("/")+2 && res.charAt(res.indexOf("/")+1) == '*' && res.charAt(res.indexOf("/")+2) == '*'&& !res.contains("if")))
                {
                    needprint++;
                    int index = res.indexOf("*");
                    res = res.substring(0,index-1);
                    if(res.length()>=3) {
                        System.out.println(res);
                        out.println(res);
                    }
                }
                else if(res.contains("*/")&& !res.contains("if"))
                {
                    needprint--;
                    int index = res.indexOf("*");
                    res = res.substring(index+1,res.length()-1);
                    if(res.length()>=2) {
                        System.out.println(res);
                        out.println(res);
                    }
                }
                else if ( needprint>0)
                {
                    needprint = 1;
                }
                else{
                    System.out.println(res);
                    out.println(res);
                }
                res = is.readLine();
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
