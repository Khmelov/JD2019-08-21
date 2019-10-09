package by.it.boytsov.jd01_14;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {

        String path = getPath(TaskA.class);
        String filename = path + "dataTaskA.bin";
        writeBinary(filename);
        List<Integer> list = new ArrayList<>(20);
        readBinary(filename, list);
        String fileTxt = path + "resultTaskA.txt";
        try (PrintWriter out = new PrintWriter(new FileWriter(fileTxt))){
            double sum = 0;
            for (Integer i : list) {
                System.out.printf("%d ", i);
                out.print(i+" ");
                sum += i;
            }
            System.out.print("\navg=" + sum/list.size());
            out.print("\navg=" + sum/list.size());
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    private static void readBinary(String filename, List<Integer>list) {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));) {
            while (dis.available() > 0) {
                int i = dis.readInt();
                list.add(i);
            }
        } catch (IOException e) {
            System.err.println("Error read " + filename);
        }

    }

    private static void writeBinary(String filename) {
        try(
                FileOutputStream f = new FileOutputStream(filename);
                BufferedOutputStream b = new BufferedOutputStream(f);
                DataOutputStream d = new DataOutputStream(b);
                ) {
            for (int i = 0; i < 20; i++){
                int value = (int)(Math.random()*100);
                d.writeInt(value);
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }



    private static String getPath(Class<TaskA> taskAClass) {
        String rootProject = System.getProperty("user.dir");
        String subPath = taskAClass.getName().replace(".", File.separator).replace(taskAClass.getSimpleName(), "");
        String path = rootProject + File.separator + "src" + File.separator + subPath;
        return path;
    }
}