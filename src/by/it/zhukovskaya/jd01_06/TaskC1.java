package by.it.zhukovskaya.jd01_06;

public class TaskC1 {
    private static char aChar = ' ';

    public static void main(String[] args) {
        String strArr[] = Poem.text.split("\n");
        int maxLength = getMaxLength(strArr);
        for (int i = 0; i < strArr.length; i++) {
            int cntSpaces = maxLength - strArr[i].length();
            if (cntSpaces > 0) {
                String wordsArr[] = strArr[i].split(" ");

                if (wordsArr.length > 1) {
                    int spaces = cntSpaces / (wordsArr.length - 1);
                    int rem = cntSpaces % (wordsArr.length - 1);
                    strArr[i] = "";
                    for (int j = 0; j < wordsArr.length; j++) {
                        strArr[i] += wordsArr[j];
                        if (j < wordsArr.length - 1)
                            strArr[i] += aChar + getSpaceCnt(spaces);
                        if (rem > 0) {
                            strArr[i] += aChar;
                            rem--;
                        }
                    }
                }
            }
            strArr[i] += "\n";
            System.out.print(strArr[i]);
        }
    }

    private static String getSpaceCnt(int count) {
        String s = "";
        for (int i = 0; i < count; i++) {
            s += aChar;
        }
        return s;
    }

    private static int getMaxLength(String arr[]) {
        int max = 0;
        for (String word : arr)
            if (word.length() > max)
                max = word.length();
        return max;
    }
}
