package Lev04.task0419;

/* 
Максимум четырех чисел
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            if (comp (a,b) >= comp(c,d)){
                System.out.println(comp (a,b));
            } else System.out.println(comp(c,d));



    }

    private static int comp(int first, int second) {
        int max = 0;
        if (first>=second){
            max = first;} else max = second;
        return max;
    }
}
