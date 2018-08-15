package Lev04.task0418;

/* 
Минимум двух чисел
*/

import java.util.Scanner;

public class Solution {
        public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            int b = scanner.nextInt(); //напишите тут ваш код
            if (a>=b){
                System.out.println(b);
            } else System.out.println(a);
        }    //напишите тут ваш код
    }