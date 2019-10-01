package by.it.krautsevich.jd01_15;

/**
 * @author mikhail krautsevich
 */

import java.io.*;

public class TaskB {
      //try to get path
    public static void main(String[] args) {

        String myPath = getPath.getMyPath(TaskB.class) ;
        String filename = myPath + "TaskB.java" ;
        String result = myPath + "TaskB.txt" ;
        StringBuilder myString = new StringBuilder() ;

/*try to read file
    */

        try (RandomAccessFile reader = new RandomAccessFile(filename , "r") )
        {while ((reader.length() - reader.getFilePointer() )!= 0)
        {
            String testLine = reader.readLine() ;

            if (testLine.isEmpty()) {myString.append("\n") ;}

            if ((testLine.length()==1)) {myString.append(testLine)  ;}

            if (!testLine.contains(Patterns.SLASH) && !testLine.contains(Patterns.MIDDLE_OF_ANNO) && (testLine.length()>1))
                {myString.append(testLine).append("\n");}

            if (testLine.contains(Patterns.ONELINECOMMENT))
                {   int position = testLine.indexOf(Patterns.ONELINECOMMENT) ;
                    if (position<2) {myString.append("");}
                    else testLine = testLine.substring(0 , position) ;
                    myString.append(testLine).append("\n");}

            if (testLine.contains(Patterns.START_ANNO))
            { int position = testLine.indexOf(Patterns.START_ANNO);
                if (position < 2)
                {myString.append("");}
                else {String myLine = testLine.substring(0 , position);
                      myString.append(myLine) ;}}

            if ((testLine.contains(Patterns.START_MANYLINE)) && (!testLine.contains(Patterns.START_ANNO)))
                {  int position = testLine.indexOf(Patterns.START_MANYLINE) ;
                    if (position==1) {myString.append("");}
                    else testLine = testLine.substring(0 , position);
                    myString.append(testLine).append("\n");
                    while (!testLine.contains(Patterns.END_MANYLINE))
                            {testLine = reader.readLine();
                            myString.append("")   ;     }
                }

            if (testLine.contains(Patterns.MIDDLE_OF_ANNO))
                     {int position = testLine.indexOf(Patterns.MIDDLE_OF_ANNO) ;
                     String myLine = testLine.substring(0, position);
                     myString.append("");}

            if (testLine.contains(Patterns.END_MANYLINE))
                        {int position_end = testLine.indexOf(Patterns.END_MANYLINE);
                        if (position_end + 1 == testLine.length()) {myString.append("");}
                        else {int lineLength = testLine.length() ;
                             String myLine = testLine.substring(position_end+2, lineLength) ;
                             myString.append("").append(myLine).append("\n") ;}}

        }}
        catch (IOException e) {
            System.out.println("Can't read file: " + filename);
        }
   //  try to write file
        try (PrintWriter printer = new PrintWriter(new FileWriter(result)))
        {printer.print(myString);}
        catch (IOException e) {
            System.out.println("Can't write file: " + result);
        }
      /*one more many-line comment
    */
    }
}