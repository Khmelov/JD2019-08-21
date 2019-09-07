package by.it.kiturka.jd01_04;
import java.util.Scanner;


//Создайте в пакете by.it.familiya.jd01_04 класс TaskA и напишите в нем метод
//static void printMulTable() для вывода на консоль таблицы умножения в следующем виде (с
//учетом пробелов):
public class TaskA {
    static void printMulTable() {
        for (int i = 2; i <= 9 ; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%1d*%1d=%-2d ",i,j,i*j);
            }
            System.out.println();
        }

    }
    // Напишите также метод static void buildOneDimArray(String line), который:
    // формирует из строки line массив вещественных чисел,
    //(можно скопировать для этого класс InOut, написанный в jd01_03 Задание A)
    // выводит в 5 колонок этот массив с названием V и индексами (тоже InOut),
    //например V[ 1 ]=12,234 V[ 2 ]=2,345 и т.д.
    // сортирует этот массив по возрастанию (см. Helper.sort в jd01_03 Задание B)
    // еще раз выводит его (см. InOut), но уже в 4 колонки с заголовками и тем же названием
    // выполняет вычисление новых (после сортировки) индексов первого и последнего элемента
    //исходного массива и печатает их в виде:
    //Index of first element=2
    //Index of last element=7
    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        double start = array[0];
    double stop = array[array.length-1];
        InOut.printArray(array,"V",5);
        Helper.sort(array);
        InOut.printArray(array,"V",4);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == start) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }
            for (int i = 0; i < array.length; i++) {
                if (array[i] == stop){
                    System.out.println("Index of last element="+i);
                    break;
                }
        }

// В основном методе public static void main(String[ ] args) класса TaskA
// вызовите printMulTable
// прочитайте с консоли строку из чисел, введенных через пробел (nextLine() в scanner-е)
// вызовите buildOneDimArray с этой строкой в качестве аргумента
    }

    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String s= scanner.nextLine();
        buildOneDimArray(s);
    }
}

