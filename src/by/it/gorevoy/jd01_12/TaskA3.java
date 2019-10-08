package by.it.gorevoy.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int positionZero = 0;
        Scanner sc = new Scanner(System.in);
        for (; ; ) {
            String stringValue = sc.next();
            if (stringValue.equals("end")) break;
            Integer value = Integer.valueOf(stringValue);
            if (value < 0)
                list.add(value);
            else if (value == 0)
                list.add(positionZero, value);
            else
                list.add(positionZero++, value);
        }
        System.out.println(list);
    }
}
