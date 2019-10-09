package by.it.boytsov.jd01_04;


import java.util.Arrays;
import java.util.Scanner;

public class TaskC
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }

    private static void buildOneDimArray(String line)
    {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 6);
        double first = array[0];
        double last = array[array.length - 1];
        mergeSort(array);
        InOut.printArray(array, "V", 6);
        int i = binarySearch(array, first);
        System.out.printf("Index of first element=%d%n", i);
        i = binarySearch(array, last);
        System.out.printf("Index of last element=%d%n", i);
    }

    private static int binarySearch(double[] array, double value)
    {
        int left = 0;
        int right = array.length - 1;
        while (left <= right)
        {
            int middle;
            middle = (left + right) / 2;
            if (array[middle] == value)
                return middle;
            else if (array[middle] > value)
                right = middle - 1;
            else left = middle + 1;
        }
        return -1;
    }

    private static void mergeSort(double[] array)
    {
        double resultArray[] = mergeSort(array, 0, array.length - 1);
        System.arraycopy(resultArray,0 ,array,0,array.length);
    }
    private static double[] mergeSort(double[] array, int left, int right)
    {
        if (right <= left)
            return array;
        else {
            int middle = (left + right) / 2;
            double[] partLeft = new double[middle-left+1];
            System.arraycopy(array,left,partLeft,0,partLeft.length);
            mergeSort(partLeft);
            double[] partRight =new double[right-middle];
            System.arraycopy(array,middle+1,partRight,0,partRight.length);
            mergeSort(partRight);
            double[] resultArray=merge(partLeft,partRight);
            return resultArray;
        }
    }
    private static double[] merge(double[] partLeft, double[] partRight) {
        int sizeOfArray = partLeft.length + partRight.length;
        double[] resArray = new double[sizeOfArray];
        int i = 0;
        int left = 0;
        int right = 0;
        while (left < partLeft.length || right < partRight.length)
        {
            if (left == partLeft.length)
            {
                while (right < partRight.length)
                    resArray[i++] = partRight[right++];
                continue;
            }
            if (right == partRight.length)
            {
                while (left < partLeft.length)
                    resArray[i++] = partLeft[left++];
                continue;
            }
            if (partLeft[left] < partRight[right])
            { resArray[i] = partLeft[left++];}
            else if (partLeft[left] == partRight[right]){
                resArray[i++]=partLeft[left++];
                resArray[i] = partRight[right++];
            }
            else {resArray[i] = partRight[right++];}
            i++;
        }
        return resArray;
    }



}