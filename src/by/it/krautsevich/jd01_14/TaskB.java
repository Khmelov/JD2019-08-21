package by.it.krautsevich.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static String getPath(Class<TaskB> taskBClass) {
        String rootProject = System.getProperty("user.dir") ;
        String subPaths = taskBClass.getName().replace("." , File.separator).
                replace(taskBClass.getSimpleName() , "") ;
        String path = rootProject + File.separator + "src" + File.separator + subPaths ;
        return path ; }

    private static void printToFile(String filename, String file, int numberOfPuncts , int numberOfWords) {
        PrintWriter writer = null ;
        try {writer = new PrintWriter(new FileWriter(file));
            writer.println("words="+ numberOfWords + ", punctuation marks=" + numberOfPuncts);
        }
        catch (IOException e) {
                System.err.println(filename + " не удается записать в файл");
                }
                finally {if (writer != null)
                writer.close();}}

    public static void main(String[] args) {

        String path = getPath(TaskB.class);
        String poem_name = path + "text.txt" ;
        File poem = new File(poem_name) ;
        String resultName = path + "resultTaskB.txt" ;





        try (
           BufferedReader reader =  new BufferedReader(new FileReader(poem))
        ) {
            int numberOfPuncts = 0;
            int numberOfWords = 0;

            String str ;
            Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+[\\s\\p{Punct}]") ;
            Pattern pattern1 = Pattern.compile("[\\p{Punct}]") ;

            while ( (str = reader.readLine() ) != null) {
                String str1 = str.replaceAll("\\.\\.\\." , "!");
                Matcher matcher1 = pattern1.matcher(str1);
                while (matcher1.find()) {numberOfPuncts++ ;}
                str1 = str1 + "!";

                Matcher matcher = pattern.matcher(str1);
                while (matcher.find()) {numberOfWords++ ;}
            }
            System.out.println("words="+ numberOfWords + ", punctuation marks=" + numberOfPuncts);
            printToFile("resultTaskB.txt", resultName, numberOfPuncts , numberOfWords) ;


        }
        catch (IOException e) {
            System.err.println(poem_name + " не удается прочитать");}

    }
}
