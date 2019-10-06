package by.it.shamuradova.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    private static Scanner scanner;
    private static List<Double> chisla = new ArrayList<>();
    private static int count;

    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);
        for (; ; ) {
            readData();
        }
    }

    private static void readData() throws InterruptedException {
        String value = scanner.next();
        try {
            Double vChislo = Double.valueOf(value);
            chisla.add(vChislo);
        } catch (NumberFormatException e) {
            Thread.sleep(100);

            count++;
            if (count > 5) {
                throw e;
            }
            for (int i = chisla.size() - 1; i >= 0; i--) {
                System.out.print(chisla.get(i) + " ");
            }
            System.out.println();
        }
    }
}





