package Lev04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[3];
        mas[0] = scanner.nextInt();
        mas[1] = scanner.nextInt();
        mas[2] = scanner.nextInt();
        int otr = 0, pol = 0;
        for (int i = 0; i < 3; i++) {
            if (mas[i] > 0) {
                pol = pol + 1;
            } else if (mas[i] < 0) {
                otr = otr +1;
            }
        }
        System.out.println("количество отрицательных чисел: " + otr);
        System.out.println("количество положительных чисел: " + pol);

    }
}
