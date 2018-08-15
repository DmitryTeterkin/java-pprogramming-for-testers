package Lev04.task0427;

/* 
Описываем числа
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if (a >= 0 && a < 1000) {
            if (a > 99 && a % 2 == 0) {
                System.out.println("четное трехзначное число");
            } else if ((a > 99 && a % 2 != 0)) {
                System.out.println("нечетное трехзначное число");
            }
            if (a > 9 && a < 99 && a % 2 == 0) {
                System.out.println("четное двузначное число");
            } else if (a > 9 && a < 100 && a % 2 != 0) {
                System.out.println("нечетное двузначное число");
            }
            if (a > 0 && a < 10 && a % 2 == 0) {
                System.out.println("четное однозначное число");
            } else if (a > 0 && a < 10 && a % 2 != 0) {
                System.out.println("нечетное однозначное число");
            }
        }
    }
}
