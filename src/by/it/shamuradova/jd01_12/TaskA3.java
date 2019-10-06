package by.it.shamuradova.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int position=0;
        for(;;){
            String value = sc.next();
            if(value.equals("end")){
                break;
            }
            Integer integer1 = Integer.valueOf(value); //п.ч. parseInt return int, boxing
            if(integer1<0){
                list.add(integer1);
            }
            if(integer1==0){
                list.add(position, integer1);
            }
            if(integer1>0){
                list.add(position++,integer1);
            }
        }
        System.out.println(list);


    }
}
