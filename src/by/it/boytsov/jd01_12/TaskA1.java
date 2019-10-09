package by.it.boytsov.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TaskA1 {
    private List<Integer> grades = new ArrayList<>();

    private void clearBad(List<Integer> grades) {
        grades.removeIf(grade -> grade < 4);
    }

    public static void main(String[] args) {
        TaskA1 container = new TaskA1();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int grade = random.nextInt(10) + 1;
            container.grades.add(grade);
        }
        System.out.println(container.grades);
        container.clearBad(container.grades);
        System.out.println(container.grades);
    }
}


