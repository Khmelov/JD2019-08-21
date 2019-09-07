package by.it.rubatskii.jd01_04;


import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] fam = new String[n];
        for (int i = 0; i < fam.length; i++)
            fam[i] = sc.next();

        int[][] zprab = new int[n][4];

        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + fam[i]);
            for (int j = 0; j < zprab[i].length; j++) {
                zprab[i][j] = sc.nextInt();
            }
        }

        int[] total = new int[n];

        for (int i = 0; i < total.length; i++) {
            for (int j = 0; j < zprab[i].length; j++) {
                total[i] = total[i] + zprab[i][j];
            }
        }

        System.out.println();
        System.out.print("Фамилия ");
        String[] kvartal = new String[4];
        for (int i = 0; i < kvartal.length; i++) {
            System.out.print(kvartal[i] = "Квартал" + (i + 1) + " ");
        }
        System.out.println("Итого");

        System.out.println("----------------------------------------");
        for (int i = 0; i < fam.length; i++) {
            System.out.printf("%9s:", fam[i]);
            for (int j = 0; j < zprab[i].length; j++) {
                System.out.printf("%-10d", zprab[i][j]);

            }
            System.out.printf("%-10d", total[i]);
            System.out.println();
        }
        System.out.println("-------------------------------------------");
        int totalYear = 0;
        for (int i = 0; i < total.length; i++) {
            totalYear = totalYear + total[i];

        }
        System.out.println("Итого " + totalYear);
        int totalZp = 0;
        for (int i = 0; i < zprab.length; i++) {
            totalZp = totalZp + zprab[i].length;

        }
        double avg =(double) totalYear / totalZp;
        System.out.printf("Среднее: %-3.4f", avg);
    }

}

