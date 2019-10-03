package by.it.zavadski.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * В классе TaskB нужно выполнить следующие шаги:
 *  В файле с текстом TaskB.txt нужно подсчитать общее количество знаков
 * препинания и слов
 *  Вывести результат на консоль в виде одной строки:
 * words=123, punctuation marks=15
 *  Продублировать вывод в консоль в файл resultTaskB.txt
 */
public class TaskB {
    private static String getClassPath(Class <?> className){
        String path= System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String classDirectory=className.getName().replace(className.getSimpleName(),"").replace(".",File.separator);
        return path+classDirectory;
    }
    public static void main(String[] args) {
        String inputFile= getClassPath(TaskB.class)+"text.txt";
        String outputFile= getClassPath(TaskB.class)+"resultTaskB.txt";
        countWordsAndMarks(inputFile,outputFile);
    }

    private static void countWordsAndMarks(String inputFilePath,String outputFilePath) {
        Pattern wordsPattern= Pattern.compile("[А-ЯЁёа-я]+");
        Pattern marksPattern=Pattern.compile("[^ А-ЯЁёа-я]+");
        try(BufferedReader fileReader=new BufferedReader(new FileReader(inputFilePath))
        ){
            int wordsCount = 0;
            int marksCount = 0;
            while (fileReader.ready()){
                String line=fileReader.readLine();
                Matcher words=wordsPattern.matcher(line);
                Matcher marks=marksPattern.matcher(line);
                while (words.find())
                    wordsCount++;
                while (marks.find())
                    marksCount++;
            }
            printCounter(wordsCount,marksCount,outputFilePath);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void printCounter(int wordsCount,int marksCount,String outputFilePath) {
        try (PrintWriter printer = new PrintWriter(new FileWriter(outputFilePath))) {
            printer.printf("words=%d, punctuation marks=%d", wordsCount, marksCount);
            System.out.printf("words=%d, punctuation marks=%d",wordsCount,marksCount);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
