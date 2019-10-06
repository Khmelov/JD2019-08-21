package by.it.shamuradova.jd01_14;

import java.io.*;

//replaceAll("...", ".")

public class TaskB {
    public static void main(String[] args) {
        String path = getPath(TaskB.class);
        String fileName = path + "text.txt"; //C:\Users\Бегенч\IdeaProjects\JD2019-08-21\src\by\it\shamuradova\jd01_14\TaskB.txt

        //считаем количество слов
        int countOfWords = countWords(fileName);
        //знаки препинания
        int punctuationMarks = countPunctuationMarks(fileName);

        //выводим это же в файл resultTaskB.txt
        //задаем текстовый файл
        String fileTxt = path + "resultTaskB.txt";
        printtoFile(fileTxt, punctuationMarks, countOfWords);

    }
    private static void printtoFile(String txt, int punctuationMarks, int countOfWords){
        try(PrintWriter out = new PrintWriter(new FileWriter(txt))
        ){
            out.println("words=" + countOfWords + "," + "punctuation marks="+ (punctuationMarks-2));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static int countPunctuationMarks(String fileName) {
        int countOfPunctuationMarks = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            char[] c = {'.', ',', '-', '?', '!', ':', ';'};
            while (line != null) {
                //line.replaceAll("\\.\\.\\.", ".");
                for (int i = 0; i < line.length(); i++) {
                   // line.replaceAll("\\.\\.\\.", ".");
                    for (int j = 0; j < c.length; j++) {
                        if (line.charAt(i) == c[j]) {
                            countOfPunctuationMarks++;
                        }
                    }
                }
                line = br.readLine();
            }
            System.out.print("punctuation marks="+ (countOfPunctuationMarks-2));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countOfPunctuationMarks;
    }

    private static int countWords(String fileName) {
        int countOfWords = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            while (line != null) {
                line = line.replaceAll("\\.\\.\\.", "").replaceAll("[^а-яА-ЯёЁ .?!]", " ").replaceAll("[\\s]{2,}", " ");
                String[] parts = line.split(" ");
                for (String s : parts) {
                    countOfWords++;
                }
                line = br.readLine();
            }
            System.out.print("words=" + countOfWords + ","); //157
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countOfWords;
    }

    private static String getPath(Class<TaskB> taskBClass) {
        String rootProject = System.getProperty("user.dir"); //C:\Users\Бегенч\IdeaProjects\JD2019-08-21
        String subPath = taskBClass.getName().replace(".", File.separator).replace(taskBClass.getSimpleName(), "");//by\it\shamuradova\jd01_14\
        String path = rootProject + File.separator + "src" + File.separator + subPath; //C:\Users\Бегенч\IdeaProjects\JD2019-08-21\src\by\it\shamuradova\jd01_14\
        return path;
    }
}
