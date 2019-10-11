package by.it.boytsov.jd01_14;

import java.io.*;

public class TaskB {
    public static void main(String[] args)
    {
        String filename = getPath(TaskB.class) + "text.txt";
        int wordCnt = countWords(filename);
        int punctuationCnt = countPunctuationMarks(filename);
        String fileTxt = getPath(TaskB.class) + "resultTaskB.txt";
        printToFile(fileTxt,punctuationCnt,wordCnt);
    }

    private static void printToFile(String txt, int punctuationMarks, int countOfWords)
    {
            try(PrintWriter out = new PrintWriter(new FileWriter(txt))
            )
            {
                out.println("words=" + countOfWords + "," + "punctuation marks="+ (punctuationMarks-2));
            }catch (IOException exception) {
                exception.printStackTrace();
            }
    }

    private static int countPunctuationMarks(String fileName) {
            int countOfPunctuationMarks = 0;
            try (BufferedReader bufferedReaderr = new BufferedReader(new FileReader(fileName))) {
                String line = bufferedReaderr.readLine();
                char[] chars = {'.', ',', '-', '?', '!', ':', ';'};
                while (line != null) {
                    for (int i = 0; i < line.length(); i++) {
                        for (int j = 0; j < chars.length; j++) {
                            if (line.charAt(i) == chars[j]) {
                                countOfPunctuationMarks++;
                            }
                        }
                    }
                    line = bufferedReaderr.readLine();
                }
                System.out.print("punctuation marks="+ (countOfPunctuationMarks-2));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            return countOfPunctuationMarks;
        }

        private static int countWords(String fileName)
        {
            int countOfWords = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line = br.readLine();
                while (line != null) {
                    line = line.replaceAll("\\.\\.\\.", "").
                            replaceAll("[^а-яА-ЯёЁ .?!]", " ").replaceAll("[\\s]{2,}", " ");
                    String[] parts = line.split(" ");
                    for (String s : parts) {
                        countOfWords++;
                    }
                    line = br.readLine();
                }
                System.out.print("words=" + countOfWords + ","); //157
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            return countOfWords;
        }

    private static String getPath(Class<TaskB> taskBClass) {
        String rootProject = System.getProperty("user.dir");
        String subPath = taskBClass.getName().replace(".", File.separator).replace(taskBClass.getSimpleName(), "");
        String path = rootProject + File.separator + "src" + File.separator + subPath;
        return path;
    }
}