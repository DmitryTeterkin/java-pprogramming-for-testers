package Lev04.task0424;

/* 
Три числа
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[3]; // объявляем массив 3-х чисел и заполняем его
        mas[0] = scanner.nextInt();
        mas[1] = scanner.nextInt();
        mas[2] = scanner.nextInt();

        //сравниваем числа
        if (mas[0] == mas[1] && mas[0]!=mas[2]) {
            System.out.println("3");
        } else if (mas[1] == mas[2] && mas[1]!= mas[0]){
            System.out.println("1");
        } else if (mas[2] == mas[0] && mas[2]!= mas[1]){
            System.out.println("2");
        }
    }
}
