package by.it.boytsov.jd01_06;

class TaskC1 {
    public static void main(String[] args) {
        String[] lineArrays = Poem.text.split("\n");
        int maxLineLength = getMaxLength(lineArrays);
        for (int i = 0; i < lineArrays.length; i++)
        {
            int spacesCount = maxLineLength - lineArrays[i].length();
                String[] wordsArray = lineArrays[i].split(" ");

                    int spaces = spacesCount / (wordsArray.length - 1);
                    int rem = spacesCount % (wordsArray.length - 1);
                    lineArrays[i]="";
                    for (int j = 0; j < wordsArray.length; j++)
                    {
                        lineArrays[i] += wordsArray[j];
                        if (j < wordsArray.length - 1)
                        lineArrays[i] += ' ' + getSpaceCount(spaces);
                        if (rem > 0)
                        {
                            lineArrays[i] += ' ';
                            rem--;
                        }
                    }

            lineArrays[i] += "\n";
            System.out.print(lineArrays[i]);
        }
    }

    private static String getSpaceCount(int count)
    {
        String string = "";
        for (int i = 0; i < count; i++)
            string += ' ';
        return string;
    }

    private static int getMaxLength(String array[])
    {
        int max = 0;
        for (String line : array)
            if (line.length() > max)
                max = line.length();
        return max;
    }
}