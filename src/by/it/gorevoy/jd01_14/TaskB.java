package by.it.gorevoy.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static String getPath(Class<?> clazz) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String subPath = clazz.getName().replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return path + subPath;
    }

    public static void main(String[] args) {
        String path = getPath(TaskB.class);
        String inputFilename = path + "text.txt";
        String text = readFromFile(inputFilename);
        //count words
        List<String> words = new ArrayList<>(Arrays.asList(text.split("[^А-ЯЁа-яё]+")));
        System.out.println("words=" + words.size());

        // count punctuation marks
        text = text.replace("...", "~");   // for this particular case only
        List<String> marks = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\p{Punct}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            marks.add(matcher.group());
        }
        System.out.println("punctuation marks=" + marks.size());

        String outputFilename = path + "resultTaskB.txt";
        //print to file
        try (PrintWriter out = new PrintWriter(
                new FileWriter(outputFilename)
        )) {
            out.print("words=" + words.size());
            out.print('\n');
            out.print("punctuation marks=" + marks.size());
        } catch (IOException e) {
            System.err.print("Error: unable to write" + outputFilename);
        }
    }

    private static String readFromFile(String filename) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader in = new BufferedReader(
                new FileReader(filename))
        ) {
            while (in.ready()) {
                text.append(in.readLine()).append('\n');
            }
        } catch (IOException e) {
            System.err.print("Error: unable to read" + filename);
        }
        return text.toString();
    }

}
