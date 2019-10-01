package by.it.kiturka.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String str;
        Integer value;
        int pos = 0;
        while (!(str = scanner.next()).equals("end")) {
            value = Integer.valueOf(str);
            if (value > 0)
                arr.add(pos++, value);
            else if (value == 0)
                arr.add(pos, value);
            else
                arr.add(value);
        }
        System.out.println(arr);
    }
}
