package Lev04.task0423;

/* 
Фейс-контроль
*/

import java.util.Scanner;

public class Solution {

        public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(System.in);
            String name1 = scanner.next();
            String age = scanner.next();
            int a = Integer.parseInt(age);

            if (a > 20) {
                System.out.println("И 18-ти достаточно");
            }
        }

}
