package by.it.yakimovich.jd01_06;

public class TaskB2 {
    public static void main(String[] args) {
        String s = Poem.text;
        String b = s.replaceAll("\\.\\.\\.", "")
                .replaceAll("[^а-яА-ЯёЁ .?!]", " ")
                .replaceAll("[\\s]{2,}", " ");
        String[] sentence = b.split("[.!?]");
        for (int i = 0; i < sentence.length; i++) {
            sentence[i] = sentence[i].trim();
        }
        for (int i = 0; i < sentence.length; i++) {
            for (int j = i+1; j < sentence.length; j++) {
                if (sentence[j].length() < sentence[i].length()) {
                    String temp = sentence[i];
                    sentence[i] = sentence[j];
                    sentence[j] = temp;
                }
            }
        }
        for (int i = 0; i < sentence.length; i++) {
            System.out.println( sentence[i]);
        }
    }
}
