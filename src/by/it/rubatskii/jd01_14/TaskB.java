package by.it.rubatskii.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        String filename = getPath(TaskB.class) + "text.txt";
        String line = null;
        int wordCnt = 0;
        int punctCnt = 0;
        String fileTxt = getPath(TaskB.class) + "resultTaskB.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filename));
             PrintWriter out2 = new PrintWriter(new FileWriter(fileTxt));) {
            Pattern ptWords = Pattern.compile("[а-яА-ЯёЁ]+");
            Pattern ptPunctuation = Pattern.compile("[-,.!:]+");
            while ((line = br.readLine()) != null) {
                Matcher mtWords = ptWords.matcher(line);
                while (mtWords.find())
                    wordCnt++;
                Matcher mtPunctuation = ptPunctuation.matcher(line);
                while (mtPunctuation.find())
                    punctCnt++;
            }
            System.out.printf("words=%d , punctuation marks=%d", wordCnt, punctCnt);
            out2.print("words="+wordCnt+ " , punctuation marks="+punctCnt);
        } catch (IOException e) {
            System.err.println("Error read " + filename);
        }
    }

    private static String getPath(Class<TaskB> taskBClass) {
        String rootProject = System.getProperty("user.dir");
        String subPath = taskBClass.getName().replace(".", File.separator).replace(taskBClass.getSimpleName(), "");
        String path = rootProject + File.separator + "src" + File.separator + subPath;
        return path;
    }
}
