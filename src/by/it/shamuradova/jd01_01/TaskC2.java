package by.it.shamuradova.jd01_01;

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
        int firstInt = sc.nextInt();
        int secondtInt = sc.nextInt();
        int sum = firstInt + secondtInt;
        System.out.println("DEC:" + firstInt + "+" + secondtInt + "=" + (firstInt + secondtInt));
        String s1 = Integer.toBinaryString(firstInt);
        String s2 = Integer.toBinaryString(secondtInt);
        String sum2 = Integer.toBinaryString(sum);
        System.out.println("BIN:" + s1 + "+" + s2 + "=" + sum2);
        String h1 = Integer.toHexString(firstInt);
        String h2 = Integer.toHexString(secondtInt);
        String sum3 = Integer.toHexString(sum);
        System.out.println("HEX:" + h1 + "+" + h2 + "=" + sum3);
        String o1 = Integer.toOctalString(firstInt);
        String o2 = Integer.toOctalString(secondtInt);
        String sum4 = Integer.toOctalString(sum);
        System.out.println("OCT:" + o1 + "+" + o2 + "=" + sum4);
    }


}
