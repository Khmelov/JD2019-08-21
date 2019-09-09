package by.it.zavadski.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**TaskB2. Вывести через \n все предложения текста в порядке возрастания количества символов
 * (!) в каждом из них. В предложениях нужно сначала заменить все небуквенные символы и их последовательности
 * на один пробел и выполнить trim() для каждого предложения.
 * Все замены выполняются без матчера.
 * @author y.zavadski
 * **/

public class TaskB2 {
    public static void main(String[] args) {
    String textInRow=Poem.text.replaceAll("\\n"," ").replaceAll("\\.\\.\\.","").replaceAll("[\\!]",".");
    String[] sentences=textInRow.split("\\."); //Array for text in one row.
        String[] clearSentences=new String[sentences.length]; //Array for modified (cleared) sentences.
        for (int index = 0; index <sentences.length ; index++) {
            clearSentences[index]=sentences[index].replaceAll("[\\.\\,\\:\\!\\?\\-]"," ").
                    replaceAll("(\\s{2,3})"," ").trim();
        }
        sortSentencesByLength(clearSentences);
        printSentences(clearSentences);
        }

    /**
     * @author=y.zavadski
     * @param clearSentences - array for sorting.
     */
    private static void sortSentencesByLength(String[] clearSentences) {
        for (int i = 0; i <=clearSentences.length; i++) {
            for (int j =i+1; j<=clearSentences.length-1; j++) {
                if ((clearSentences[i].length()  > clearSentences[j].length())) {
                    String buffer=clearSentences[j];
                    clearSentences[j]=clearSentences[i];
                    clearSentences[i]=buffer;
                }
            }
        }
    }
    /**@author=y.zavadski
     * @param sentencesForPrint print specified String array OR String.
     **/
    private static void printSentences(String[] sentencesForPrint){
        for (String s : sentencesForPrint) {
            System.out.printf("%s\n", s);
        }
    }
        private static void printSentences(String sentencesForPrint){
            System.out.printf("%s\n",sentencesForPrint);
    }
}