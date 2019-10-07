package by.it.gorevoy.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    private static String getPath(Class<?> clazz) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String subPath = clazz.getName().replace(clazz.getSimpleName(), "")
                .replace(".", File.separator);
        return path + subPath;
    }

    public static void main(String[] args) {
        String path = getPath(TaskA.class);
        String fileBin = path + "dataTaskA.bin";
        writeBinary(fileBin);

        List<Integer> list = new ArrayList<>(20);
        readBinaryFile(fileBin, list);
        printToConsole(list);

        String fileTxt = path + "resultTaskA.txt";
        printToTxtFile(list, fileTxt);
    }

    private static void writeBinary(String fileBin) {
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(fileBin)))
        ) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 20));
            }
        } catch (IOException ex) {
            System.err.println("Error: unable to write" + fileBin);
        }
    }

    private static void readBinaryFile(String fileBin, List<Integer> list) {
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(fileBin)))
        ) {
            while (dis.available() > 0) {
                int nextInt = dis.readInt();
                list.add(nextInt);
            }
        } catch (IOException e) {
            System.err.println("Error: unable to read" + fileBin);
        }
    }

    private static void printToConsole(List<Integer> list) {
        double sum = 0;
        double count = 0;
        for (Integer i : list) {
            System.out.print(i + " ");
            sum += i;
            count++;
        }
        System.out.println("\navg=" + sum / count);
    }

    private static void printToTxtFile(List<Integer> list, String fileTxt) {
        try (
                PrintWriter out = new PrintWriter(
                        new FileWriter(fileTxt))
        ) {
            double sum = 0;
            double count = 0;
            for (Integer i : list) {
                out.print(i + " ");
                sum += i;
                count++;
            }
            out.println("\navg=" + sum / count);
            out.flush();
        } catch (
                IOException e) {
            System.err.println("Error: unable to write" + fileTxt);
        }
    }
}
