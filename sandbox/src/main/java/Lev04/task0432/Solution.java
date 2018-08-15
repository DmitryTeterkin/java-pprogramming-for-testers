package Lev04.task0432;



/* 
Хорошего много не бывает
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Str = scanner.next();
        String count = scanner.next();
        int a = Integer.parseInt(count);
        int i = 0;
        if (a > i) {
            while (i != a) {
                System.out.println(Str);
                i = i + 1;
            }
        }
    }
}
