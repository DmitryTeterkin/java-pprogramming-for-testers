package Lev04.task0426;

/* 
Ярлыки и числа
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        System.out.println(((a != 0) ? (((a > 0) ? ((a % 2 == 0) ? ("положительное четное ") : ("положительное нечетное ")) : ((a % 2 == 0) ? ("отрицательное четное ") : ("отрицательное нечетное "))) + "число") : ("ноль")));
    }      //напишите тут ваш код

}
