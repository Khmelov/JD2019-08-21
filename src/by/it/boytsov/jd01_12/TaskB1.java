package by.it.boytsov.jd01_12;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        ArrayList<String> list =new ArrayList<>();
        Map<String,Integer>map=new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        for(;;)
        {
            String line = scanner.next();
            if(line.equals("end"))
                break;
            line = line.replaceAll("[.?!()\",—:;]", "");
            list.add(line);
        }
        for (int i = 0; i < list.size(); i++) {
            int counter=0;
            for(String aList:list)
            {
                if(list.get(i).equals(aList))
                    counter++;
            }
            map.putIfAbsent(list.get(i),counter);
        }
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey()+ "=" + entry.getValue());
        }
    }
}
