package by.it.yakimovich.jd01_04;

import java.util.Scanner;

public class TaskA {

    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        buildOneDimArray(str);
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double start = array[0];
        double fin = array[array.length - 1];
        InOut.printArray(array, "V", 5);

        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == start) {
                System.out.println("Index of first element=" + i);
                break;
            }

        }
        for (int i = 0; i < array.length; i++) {
            if (array[i]==fin) {
                System.out.println("index of last element="+ i);
                break;
            }

        }





    }




}