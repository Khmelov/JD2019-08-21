package by.it.agadzhanov.jd01_15;

import java.io.*;

public class TaskB {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();  //Однострочный комментарий
        try (BufferedReader reader = new BufferedReader(
                new FileReader(TaskA.dir(TaskB.class) + "TaskB.java"))) {
             /*Многострочный
               комментарий
               №1
             */
            char readChar1;
            char readChar2;
            boolean endComment = false;

            while (reader.ready()) {
                readChar1 = (char) reader.read();
                if (readChar1 == '/') {
                    reader.mark(1);
                    readChar2 = (char) reader.read();

                    //Если найден однострочный комметрарий
                    if (readChar2 == '/') {
                        while ((char) reader.read() != '\r') {
                        }
                        continue;

                        //Если найден многострочный или JavaDoc комментарий
                    } else if (readChar2 == '*') {
                        while (!endComment) {
                            readChar1 = (char) reader.read();
                            if (readChar1 == '*') {
                                reader.mark(1);
                                readChar2 = (char) reader.read();
                                if (readChar2 == '/') {
                                    endComment = true;
                                } else reader.reset();
                            }
                        }
                        endComment = false;
                        continue;
                    }

                    //Если просто встретился символ /, вернуть указатель на место
                    else reader.reset();
                }
                sb.append(readChar1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter writer = new PrintWriter(
                new FileWriter(TaskA.dir(TaskB.class) + "TaskB.txt"))) {
            writer.write(sb.toString());
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Комментарий JavaDoc
         */
        /*Многострочный
          комментарий
          №2
         */
    }
}
