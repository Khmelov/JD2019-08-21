package by.it.agadzhanov.jd01_15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        String[] parts;

        //Вывести на консоль имя текущего каталога
        String strPath = TaskA.dir(TaskC.class);
        File file = new File(strPath);
        System.out.println(file.getAbsolutePath());

        //Пока не была введена команда end
        while (!(command = scanner.nextLine()).equals("end")) {
            parts = command.split(" ", 2);

            //Если поступила команда cd ..
            if (parts[0].equals("cd")) {
                if ((parts[1].equals(".."))) {
                    String parentDir = file.getParent();
                    file = new File(parentDir);
                    System.out.println(file.getAbsolutePath());
                }

                //Если поступила команда cd имя_папки_в_текущем_каталоге
                else {
                    String newPath = file.getAbsolutePath() + File.separator + parts[1];
                    File tempFile = new File(newPath);
                    if (tempFile.exists()) {
                        file = new File(newPath);
                        System.out.println(file.getAbsolutePath());
                    } else System.out.println("Invalid directory path: " + newPath);
                }
            }

            //Если поступила команда dir
            if (parts[0].equals("dir")) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File fileElement : files) {
                        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                        if (fileElement.isFile()) {
                            long totalSpace = fileElement.getTotalSpace();
                            System.out.printf(sdf.format(fileElement.lastModified()) + "       " + "%15d " + "%-20s", totalSpace, fileElement.getName());
                            System.out.println();
                        } else {
                            System.out.printf(sdf.format(fileElement.lastModified()) + " <DIR> " + "                " + "%-20s",fileElement.getName());
                            System.out.println();
                        }
                    }
                }
            }
        }
    }
}
