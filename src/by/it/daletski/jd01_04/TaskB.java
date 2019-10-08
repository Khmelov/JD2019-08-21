package by.it.daletski.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println ("Введите количество человек: ");
        int countPerson = sc.nextInt ();
        System.out.println ("Введите фамилии " + countPerson + " человек");
        String numberOfPerson = sc.nextLine ();
        String[] nameArr = new String[countPerson];

        for (int i = 0; i < countPerson; i++)
            nameArr[i] = sc.nextLine ();
        int arr[][] = new int[countPerson][4];
        for (int i = 0; i < countPerson; i++) {
            System.out.println ("Введите зарплату по кварталам для " + nameArr[i]);
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextInt ();
            }
        }

        System.out.printf ("%-15s%-10s%-10s%-10s%-10s%-10s%n", "Фамилия", "Квартал 1", "Квартал 2", "Квартал 3", "Квартал 4", "Итого: ");
        System.out.println ("-----------------------------------------------------------------");
        int sumWage = 0, avg = 0, count = 0, sum = 0;
        for (int i = 0; i < countPerson; i++) {
            System.out.printf ("%-15s", nameArr[i]);
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
                avg += arr[i][j];
                count++;
                System.out.printf ("%10d", arr[i][j]);
            }
            System.out.printf ("%-10d", sum);
            sumWage += sum;
        }
        System.out.println ("-----------------------------------------------------------------");
        System.out.printf ("%-15s%-10d%n", "Итого", sumWage);
        System.out.printf ("%-15s%-10.4f%n", "Средняя:", (count > 0) ? ((double) avg / count) : 0);
    }
}


