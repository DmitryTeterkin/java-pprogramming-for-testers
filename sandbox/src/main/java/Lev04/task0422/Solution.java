package Lev04.task0422;

/* 
18+
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.next();
        String age = scanner.next();
        int a = Integer.parseInt(age);

        if (a < 18) {
            System.out.println("Подрасти еще");
        }
    }
}
