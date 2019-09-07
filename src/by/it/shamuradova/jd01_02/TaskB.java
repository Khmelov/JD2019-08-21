package by.it.shamuradova.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        step1();
        Scanner sc = new Scanner(System.in);
        step2((sc.nextInt()));
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        step3(a, b, c);
    }
    //step1() выводит числа от 1 до 25 в виде матрицы N x N слева направо и
    //сверху вниз (т.е. N = 5). После каждого числа один пробел.
    static void step1() {
        for (int i = 1; i < 26; i++) {
            System.out.print(i + " ");
            if (i % 5 == 0) {
                System.out.println();
            }
        }
    }

    //В main ввести с консоли через объект типа Scanner число от 1 до 12 и с
    //ним вызвать метод step2(int month), который выводит на консоль русское
    //название месяца строчными буквами, соответствующего этому числу через
//switch. Сообщить об ошибке “нет такого месяца” для некорректных чисел
    //во вводе (это должна быть default – ветка для switch).
    static void step2(int month) {
        String monthString;
        switch (month) {
            case 1:
                monthString = "январь";
                break;
            case 2:
                monthString = "февраль";
                break;
            case 3:
                monthString = "март";
                break;
            case 4:
                monthString = "апрель";
                break;
            case 5:
                monthString = "май";
                break;
            case 6:
                monthString = "июнь";
                break;
            case 7:
                monthString = "июль";
                break;
            case 8:
                monthString = "август";
                break;
            case 9:
                monthString = "сентябрь";
                break;
            case 10:
                monthString = "октябрь";
                break;
            case 11:
                monthString = "ноябрь";
                break;
            case 12:
                monthString = "декабрь";

                break;
            default:
                monthString = "нет такого месяца";

        }
        System.out.println(monthString);
    }

    //Рассчитайте и выведите корни (или один корень) квадратного уравнения.
    //Если корня нет, то нужно вывести сообщение “корней нет”.
   // Параметры (a b c) уравнения нужно вводить в main через тот же Scanner и
    //затем передавать в метод step3(double a, double b, double c).
    //Для извлечения D используйте метод Math.sqrt(discriminant)
    static void step3(double a, double b, double c) {
        double diskriminant;
        double x1;
        double x2;
        if (a != 0) {
            diskriminant = b * b - 4 * a * c;
            if (diskriminant > 0) {
                x1 = (-b + (Math.sqrt(diskriminant))) / (2 * a);
                x2 = (-b - (Math.sqrt(diskriminant))) / (2 * a);
                System.out.println(x1 + " " + x2);
            }
            if (diskriminant == 0) {
                x1 = -b / (2 * a);
                x2 = -b / (2 * a);
                System.out.println(x1 + " " + x2);
            }
            if (diskriminant < 0) {
                System.out.println("корней нет");
            }
        } else {
            System.out.println("корней нет");
        }
    }
}
