package by.it.yakimovich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        String[] familiya = new String[a];
        for (int i = 0; i < a; i++) {
            familiya[i] = scanner.next();
        }
        int[][] zarplata = new int[a][4];
        for (int i = 0; i < a; i++) {
            System.out.println("Введите зарплату для" + familiya[i]);
            for (int j = 0; j < 4; j++) {
                zarplata[i][j] = scanner.nextInt();
            }
        }
        System.out.printf("%11s %-10s %-10s %-10s %-10s %-10s", "Фамилия", "Квартал 1", "Квартал 2", "Квартал 3", "Квартал 4", "Итого");
        System.out.println();
        int s = 0;
        int sum = 0;
        double avg = 0;
        for (int i = 0; i < a; i++) {
            System.out.printf("%10s:", familiya[i]);
            for (int q = 0; q < 4; q++) {
                System.out.printf(" %-10d", zarplata[i][q]);
                s += zarplata[i][q];
            }
            sum += s;
            System.out.printf(" %-10d", s);
            s = 0;
            System.out.println();
        }
        System.out.printf("%11s %-10d","Итого", sum);
        avg = (double) sum / (a * 4);
        System.out.println();
        System.out.printf("%11s %-10.4f", "Средняя", avg);

    }
}

