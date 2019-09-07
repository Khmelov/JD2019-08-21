package by.it.rubatskii.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и 4 раза выводит их сумму с обозначением системы счисления на экран в
ДЕСЯТИЧНОМ ДВОИЧНОМ ШЕСТНАДЦАТИРИЧНОМ ВОСЬМИРИЧНОМ виде

Вот пример ввода с клавиатуры:
34 26

Тогда вывод ожидается такой (обратите внимание на регистр букв):
DEC:34+26=60
BIN:100010+11010=111100
HEX:22+1a=3c
OCT:42+32=74
*/
class TaskC2 {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int a, b, c;
        System.out.printf("Введите 34 26");
        a = sc.nextInt();
        b = sc.nextInt();
        c = a + b;
        System.out.println("DEC:" + a + "+" + b +"=" + c);
        // Бинарный формат числа
        String convert = Integer.toBinaryString(a);
        String convert1 = Integer.toBinaryString(b);
        String convert2 = Integer.toBinaryString(c);
        System.out.println("BIN:" + convert + "+" + convert1 +"=" + convert2);
        // Шеснадцатиричная форма
        convert = Integer.toHexString(a);
        convert1 = Integer.toHexString(b);
        convert2 = Integer.toHexString(c);
        System.out.println("HEX:" + convert + "+" + convert1 +"=" + convert2);
        // Восьмиричная форма
        convert = Integer.toOctalString(a);
        convert1 = Integer.toOctalString(b);
        convert2 = Integer.toOctalString(c);
        System.out.println("OCT:" + convert + "+" + convert1 +"=" + convert2);
     }

}
