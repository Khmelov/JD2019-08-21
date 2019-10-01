package by.it.shamuradova.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    private static String getPath (Class < TaskA > taskAClass) {  //собираем путь к файлу
        //выделили составление путь к файлу в метод, т.к. понадобится несколько раз
        //составляем путь к файлу
        String rootProject = System.getProperty("user.dir"); //C:\Users\Бегенч\IdeaProjects\JD2019-08-21

        String subPath = taskAClass.getName().replace(".", File.separator).replace(taskAClass.getSimpleName(), "");
        //заменили точки на /, и удалили в конце TaskA
        // by\it\shamuradova\jd01_14\

        String path = rootProject + File.separator + "src" + File.separator + subPath;//итоговый путь
        return path;
    }
    private static void printToFile(List<Integer> list, String fileTxt) {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileTxt))
        ) {
            double sum2 = 0.0;
            for (int i = 0; i < list.size(); i++) {
                sum2 = sum2 + list.get(i);
                out.print(list.get(i) + " ");
            }
            out.println();
            out.println("avg=" + sum2 / list.size());
            out.flush();

        }catch(IOException e){
            System.err.println("Error read" + fileTxt);
        }
    }
    private static void printConsol(List<Integer> list) {
        double sum = 0.0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println("avg=" + sum / list.size());
    }
    private static void readBinary(String fileNAme, List<Integer> list) {
        try (
                DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(fileNAme)))
        ) {
            //available() возвращает, сколько байт осталось до конца
            while (dis.available() > 0) {
                //извлекаем из dis числа
                int i = dis.readInt();
                list.add(i);
            }
        } catch (IOException e) {
            System.err.println("Error read" + fileNAme);
        }
    }
    private static void writeBinary(String fileNAme) {
        try (
                DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileNAme)))
        ) {
            //записываем в двоичный файл случайные числа
            for (int i = 0; i < 20; i++) {
                int value = (int) (Math.random() * 100);
                dos.writeInt(value);
            }
        } catch (IOException e) {
            System.err.println("Error write" + fileNAme);
        }
    }
    public static void main(String[] args) {
        String path = getPath(TaskA.class);

        //составить имя файла
        String fileName = path + "dataTaskA.bin";

        //создаем потоки которые записывают int
        writeBinary(fileName);

        List<Integer> list = new ArrayList<>(20);
        //читаем, что записали
        //прочитанное поместить в коллекцию
        readBinary(fileName, list);
        //выводим в консоль
        printConsol(list);

        //выводим это же в файл
        String fileTxt = path + "resultTaskA.txt"; //зададим текстовый файл
        //записываем в текстовый файл
        //BufferWriter не пишем, п.ч. PrintWriter уже забуферезированный
        printToFile(list, fileTxt);
        }
    }




