package by.it.kiturka.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
       // System.out.println("Введите 10 чисел:");
        Scanner sc = new Scanner(System.in);
        int[] mas =  new int[10]; // Прочитаем с клавиатуры массив mas,который будет состоять из 10 чисел
        for ( int i = 0; i <mas.length; i++) { // создаем цикл для заполнения массива
            mas[i] = sc.nextInt();
        }
        step1(mas); // Для того, чтобы метод Step1 начал работать, сначала вызываем его. Затем в () передаем туда прочитанный массив
        step2(mas);
        step3(mas);
    }
    // Найти самое маленькое и самое большое число массива. Вывести на
    //консоль найденные минимум и максимум в одну строку через пробел.
    static void step1(int[ ] mas){
    int min = mas[0]; // минимальным элементом считаем первый эллемент массива
    int max = mas[0]; // тоже самое
        for (int element : mas) {
            if (min > element) min = element;
            if (max < element) max = element;
        }
 System.out.println(min + " "+ max);
    }
    // Вывести на консоль те числа, значение которых строго меньше
    //среднего арифметического (типа double) в этом массиве.
    private static void step2(int[] mas){
        double ap = 0;
        for (int element : mas) {
            ap = ap + element ; //
        }
        ap = ap / mas.length;
        for (int element : mas){
            if (element < ap) System.out.print(element + " ");
        }
        System.out.println();
    }
    // Найти и вывести номер (т.е. индекс) самого маленького числа.
    //Если же таких чисел будет несколько, вывести все найденные индексы
    //минимума через пробел в порядке убывания.
    private static void step3(int[] mas){
        int min = mas[0]; // минимальным элементом считаем первый эллемент массива

        for (int element : mas) {
            if (min > element)
                min = element;

        }
        for (int i = mas.length-1; i >=0; i--){
            if (mas[i] == min){
                System.out.print(i + " ");
            }
        }


    }

}
