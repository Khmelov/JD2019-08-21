package by.it.rojas.jd04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String [] soname = new String[n];
        for (int i = 0; i <n ; i++)
        {
            soname[i] = sc.next();
        }
        int [] [] money = new int[n][4];

        for (int i = 0; i <n; i++) {
            System.out.println("Введите зарплату для " + soname[i]);
            for (int j = 0; j <4; j++) {
                money[i][j] = sc.nextInt();
            }
        }
        System.out.printf("%11s %-10s %-10s %-10s %-10s %-10s","Фамилия","Квартал 1","Квартал 2","Квартал 3","Квартал 4","Итого");
        System.out.println();
        int s = 0;
        int sum = 0;
        double medium;
        for (int i = 0; i <n; i++) {

            System.out.printf("%10s:",soname[i]);
            for (int i1 = 0; i1 < 4; i1++) {
                System.out.printf(" %-10d",money[i][i1]);
                s+= money [i][i1];
            }
            sum+= s;
            System.out.printf(" %-10d",s);
            s =0;
            System.out.println();

        }
        System.out.printf("%11s %-10d","Итого",sum);
        medium = (double)sum/(n*4);
        System.out.println();
        System.out.printf("%11s %-10.4f","Средняя",medium);
    }
}
