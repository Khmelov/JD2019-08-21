package by.it.rojas.jd14;

import java.io.*;

public class TaskB {
    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path + clDir;
    }
    public static void main(String[] args) {
        int countwords = 0;
        int countpunmarks = 0;
        try (BufferedReader inp = new BufferedReader(
                new FileReader(dir(TaskB.class)+"text.txt"));
             PrintWriter out2 = new PrintWriter(new FileWriter(dir(TaskB.class)+"resultTaskB.txt"))
        ){

            String res = inp.readLine();

            while (res !=null) {
                String[] a = res.split("[^а-яА-ЯёЁ]+");
                int c = a.length;
                countwords += c;
                String[] b = res.split("[а-яА-ЯёЁ ]+");
                int d = b.length-1;
                if (b.length  == 0)
                    d++;
                countpunmarks += d;
                res = inp.readLine();
            }
            System.out.println("words="+countwords+", punctuation marks="+countpunmarks);
            out2.print("words="+countwords+", punctuation marks="+countpunmarks);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
