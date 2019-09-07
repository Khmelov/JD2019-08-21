package by.it.shamuradova.jd01_02;

import java.util.Scanner;

public class TaskA {
    private static int[] mas;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] mas = new int[10];

        for (int i = 0; i < mas.length; i++) {
            mas[i] = sc.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }

    //Найти самое маленькое и самое большое число массива. Вывести на
    //консоль найденные минимум и максимум в одну строку через пробел.
    private static void step1(int[] mas) {
        TaskA.mas = mas;
        int min = mas[0];
        int max = mas[0];

        for (int element : mas) {
            if (element < min) {
                min = element;
            }
            if (element > max) {
                max = element;
            }
        }
        System.out.println(min + " " + max);
    }

    //Вывести на консоль те числа, значение которых строго меньше
    //среднего арифметического (типа double) в этом массиве.
    private static void step2(int[] mas) {
        double avg = 0;
        for (int element : mas) {
            avg = avg + element;
        }
        avg = avg / mas.length;
        for (int element : mas) {
            if (element < avg) {
                System.out.print(element + " ");
            }

        }
    }

    //Найти и вывести номер (т.е. индекс) самого маленького числа.
    //Если же таких чисел будет несколько, вывести все найденные индексы
    //минимума через пробел в порядке убывания.
    private static void step3(int[] mas) {
        int min = mas[0];

        for (int element : mas) {
            if (min > element) {
                min = element;
            }
        }
        for (int i = mas.length - 1; i >= 0; i--) {
            if (mas[i] == min) {
                System.out.print(i + " ");

            }
        }

    }
}
