package by.it.rubatskii.jd01_03;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array, "V", 3);
        System.out.printf("%n" + "Min array " + "=" + Helper.findMin(array));
        System.out.printf("%n" + "Max array " + "=" + Helper.findMax(array));


    }
}
