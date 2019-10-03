package by.it.yakimovich.jd01_14;

import java.io.*;

public class TaskB {
    public static void main(String[] args) {

        int punctuationMarkCount = 0;
        int wordCount = 0;
        String line;
        String[] linePunctuationMarks;
        String[] lineWords;

        try (BufferedReader reader = new BufferedReader(new FileReader(TaskA.dir(TaskB.class) + "text.txt"))) {
            while ((line = reader.readLine()) != null) {
                linePunctuationMarks = line.split("[а-яА-яёЁ ]+");
                lineWords = line.split("[-:!,.? ]+");
                for (String punctuationMark : linePunctuationMarks) {
                    if (!punctuationMark.equals(""))
                        punctuationMarkCount++;
                }
                for (String word : lineWords) {
                    if (!word.equals(""))
                        wordCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(TaskA.dir(TaskB.class) + "resultTaskB.txt"))) {
            System.out.println("\nwords=" + wordCount + ", punctuation marks=" + punctuationMarkCount);
            printWriter.print("words=" + wordCount + ", punctuation marks=" + punctuationMarkCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
