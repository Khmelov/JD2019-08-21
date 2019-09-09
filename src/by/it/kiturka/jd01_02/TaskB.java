package by.it.kiturka.jd01_02;


import java.util.Scanner;


public class TaskB {
    public static void main(String[] args) {
        step1(); // вызываем метод step1


        Scanner scanner = new Scanner(System.in); // переменной scanner присваиваем вводимые значения
        int month = scanner.nextInt();
        step2(month);


        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        step3(a, b, c);


    }


    // step1 выводит числа от 1 до 25 в виде матрицы N * N слева направо и сверху вниз(т.е N = 5). После каждого числа один пробел.
    private static void step1() {
        for (int i = 0; i <= 25; i++) {
            System.out.print(i + " ");
            if (i % 5 == 0) System.out.println();
        }
    }



    /* в метод main ввести с консоли через объект типа Scanner число от 1 до 12 и с ним вызвать метод step2(int month),
    который выводит на консоль русское название месяца строчными буквами, соответствующего этому числу через switch.
    Сообщить об ошибке "нет такого месяца" для некорректных чисел во вводе( это должно быть default - ветка для switch.
     */

    private static void step2(int month) {
        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");

        }
    }


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





