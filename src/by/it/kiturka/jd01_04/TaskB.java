package by.it.kiturka.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);   //выводим число работников
        int chisloRabotnikov = sc.nextInt();

        String [] surname = new String [chisloRabotnikov]; //одномерный массив из фамилий
        for (int i = 0; i < surname.length; i++) {
            surname[i] = sc.next();
        }

        int [] [] zarplataRabotnikov = new int [chisloRabotnikov][4];

        for(int i=0; i<chisloRabotnikov; i++){
            System.out.println("Введите зарплату для " + surname[i]);
            for(int j=0; j<zarplataRabotnikov[i].length; j++){
                zarplataRabotnikov[i][j]=sc.nextInt();
            }
        }


        int [] total = new int [chisloRabotnikov];
        for(int i=0; i<total.length; i++){
            for (int j = 0; j< zarplataRabotnikov[i].length; j++){
                total[i]=total[i] + zarplataRabotnikov[i][j];
            }
        }



        System.out.println();
        System.out.print("Фамилия   ");
        String [] kvartal = new String [4];
        for (int i = 0; i < kvartal.length; i++) {
            System.out.print(kvartal[i]="Квартал"+ (i+1) + "  ");
        }
        System.out.println("Итого");
        System.out.println("--------------------------------------------------------");

        for(int i=0; i<surname.length; i++){
            System.out.printf("%-5s:", surname[i]);
            for(int j=0; j<zarplataRabotnikov[i].length; j++){
                System.out.printf("%-10d", zarplataRabotnikov[i][j]);
            }
            System.out.printf("%-15d", total[i]);
            System.out.println();
        }
        System.out.println("--------------------------------------------");

        double totalForTheYear=0;
        for(int i=0; i<total.length;i++){
            totalForTheYear = totalForTheYear + total[i];
        }
        System.out.println("Итого     " + totalForTheYear);

        int kolichestvoZarplat = 0;
        for (int i = 0; i < zarplataRabotnikov.length; i++) {
            kolichestvoZarplat = kolichestvoZarplat + zarplataRabotnikov[i].length;
        }

        double theAverage = (double) (totalForTheYear / kolichestvoZarplat);
        System.out.printf("Среднее: %-3.4f", theAverage);

    }

    private static int sum(int number) {
        if (number == 1) {
            return number;
        }

        return number + sum(number - 1);
    }



}

