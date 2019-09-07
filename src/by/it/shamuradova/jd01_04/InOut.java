package by.it.shamuradova.jd01_04;

public class InOut {


    public static double[] getArray(String line){

        line= line.trim();                                 //удаление пробелов в начале и в конце
        String[] s = line.split(" ");                  //преобразование строки в массив .var ;  ctr + alt +v
        double [] array = new double[s.length];          //создаем новый массив, который будем возвращать и устанавливаем длинну s.length
        for (int i = 0; i < s.length; i++) {                 //каждому элементу возр массива присваиваем элемент
                                                             // от s, который parseDouble
            array[i] = Double.parseDouble(s[i]);
        }
        return array;
    }

    static void printArray(double[]arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printArray (double[] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf( "%s[%d]=%-9.3f", name, i, arr[i]);
            if((i+1)%columnCount==0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
