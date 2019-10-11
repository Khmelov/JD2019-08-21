package by.it.boytsov.jd01_04;

import java.util.Scanner;

public class TaskB
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        String [] surnames=new String[n];
        for (int i = 0; i < n ; i++)
        {
            surnames[i]=scanner.next();
        }
        int[][] costs = new int[n][4];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < 4; j++) {
                costs[i][j]=scanner.nextInt();
            }
        }
        int sum=0;
        int count=0;
        for (int i = 0; i < n; i++){
        System.out.printf("%s\t",surnames[i]);
        for (int j = 0; j < 4; j++) {
            System.out.printf("%d\t",costs[i][j]);
            sum+=costs[i][j];
            count++;
        }
        System.out.println(); }
        System.out.printf("Итого %d\n",sum);
        double average=(double)sum/(double)count;
        System.out.printf("Средняя %f\n",average);
    }

}