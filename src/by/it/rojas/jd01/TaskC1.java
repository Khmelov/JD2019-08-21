package by.it.rojas.jd01;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должна появится в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
import java.util.*;

class TaskC1 {
    public static void main(String [] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Введите числа");

        int i1=sc.nextInt();
        int i2=sc.nextInt();
        int i3=i1+i2;

        System.out.println("Sum" + " = " + i3);

    }
}
