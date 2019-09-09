package by.it.zlotnikova.jd01_06;

import java.util.Arrays;

public class TaskC1 {

    public static void main(String[] args) {
        String poem = Poem.text;
        String[] lines = poem.split("\n");

        int max = Integer.MIN_VALUE;
        for (String line : lines) {
            if (line.length() > max) {
                max = line.length();
            }
        }

        for (String line : lines) {

            int addSpaces = max - line.length();
            String[] words = line.split(" ");

            int[] spacesCounter = getSpacesCounter(addSpaces, words.length);

            StringBuilder newLine = new StringBuilder();
            newLine.append(words[0]);
            for (int j = 0; j < words.length - 1; j++) {
                newLine.append(getSpacesString(spacesCounter[j])).append(words[j + 1]);
            }
            System.out.println(newLine.toString());
        }
    }

    private static int[] getSpacesCounter(int spaces, int words){
        int places = words-1;
        int[] counter = new int[places];
        Arrays.fill(counter, 1+ spaces / (places));
        for (int j = 0; j <spaces % (places); j++) {
            counter[j] += 1;
        }
        return counter;
    }

    private static String getSpacesString(int count) {
        StringBuilder spacesString = new StringBuilder();
        for (int i = 0; i < count; i++) {
            spacesString.append(" ");
        }
        return spacesString.toString();
    }
}
