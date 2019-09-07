package by.it.yuntsevich.jd01_06;

public class TaskC1 {
    public static void main(String[] args) {
        String[] text = Poem.text.split("\n");
        int maxLength = 0;
        for (String aText : text) {
            if (maxLength < aText.length()) {
                maxLength = aText.length();
            }
        }

        String[] result = new String[text.length];

        for (int i = 0; i < text.length; i++) {
            int lineLength = text[i].length();
            if (lineLength == maxLength) {
                result[i] = text[i];
                continue;
            }
            int  maxLineLength = maxLength;

            String[] words = text[i].split(" ");

            maxLineLength = maxLineLength+words.length-1;

            while (lineLength < maxLineLength) {
                for (int j = 0; j < words.length - 1; j++) {
                    words[j] = words[j] + " ";
                    lineLength++;
                    if (lineLength == maxLineLength) break;
                }
            }

            String sb = "";
            for (int k = 0; k < words.length; k++) {
                sb = sb + words[k];
            }
            result[i] = sb;
        }
        for (String s : result) {
            System.out.println(s);
        }
    }
}

