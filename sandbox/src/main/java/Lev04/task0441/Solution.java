package Lev04.task0441;


/* 
Как-то средненько
*/
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[3];
        mas[0] = scanner.nextInt();
        mas[1] = scanner.nextInt();
        mas[2] = scanner.nextInt();
        int max = 0;
        //сортировка пузырьком :) максимальное число должно быть первым.
        for (int j = 0; j<2; j++) {
            for (int i = 0; i < 2; i++) {
                if (mas[i] < mas[i + 1]) {
                    max = mas[i+1];
                    mas[i+1] = mas[i];
                    mas[i] = max;
                }
            }
        }
        System.out.println(mas[1]);
    }
}
