package Lev04.task0428;

/* 
Положительное число
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[3];
        mas[0] = scanner.nextInt();
        mas[1] = scanner.nextInt();
        mas[2] = scanner.nextInt();
        int pol = 0;
        for (int i = 0; i < 3; i++) {
            if (mas[i] > 0) {
                pol = pol + 1;
            }
        }
        System.out.println(pol);
    }
}
