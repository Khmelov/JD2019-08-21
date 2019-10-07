package by.it.kiturka.jd01_04;

public class TaskC {
    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];
        Helper.sort(array);



        int i = binarySearch(array, first);
        int i2 = binarySearch(array, last);


        InOut.printArray(array, "V", 5);
        InOut.printArray(array, "V", 4);

        System.out.println("Index of first element=" + i);
        System.out.println("Index of last element=" + i2);
    }

    static void mergeSort(double[] array) {

    }

    static int binarySearch(double[] array, double value) {
        int firstIndex = 0;
        int lastIndex = array.length - 1;

        //условие прекращения
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;

            if (array[middleIndex] == value) {
                return middleIndex;
            } else if (array[middleIndex] < value) {
                firstIndex = middleIndex + 1;
            } else if (array[middleIndex] > value) {
                lastIndex = middleIndex - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        buildOneDimArray("22 55 66 12 14 88 77 99");
    }
}
