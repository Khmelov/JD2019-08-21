package by.it.boytsov.jd01_04;

import java.util.Scanner;

public class TaskA
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        printMulTable();
        String line = scanner.nextLine();
        buildOneDimArray(line);

    }
    static void printMulTable()
    {
    //int res;
    for (int i = 2; i < 10 ; i++) {
        for (int j = 2; j < 10 ; j++) {
            //res = i*j;
            System.out.printf("%1d*%1d=%-2d ",i,j,i*j);
        }
        System.out.println();
    }
    }
    static void buildOneDimArray(String line)
    {
       double[] array = InOut.getArray(line);
       InOut.printArray(array,"V",5);
       double first=Helper.findFirst(array);
       double last=Helper.findLast(array);
       Helper.sort(array);
       InOut.printArray(array,"V",4);
       Helper.ShowFirstLast(array,first,last);
    }
}
