package Lev04.task0436;


/* 
Рисуем прямоугольник
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                System.out.print("8");
            }
            System.out.println();
        }
    }
}
