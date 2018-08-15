package Lev04.task0421;

/* 
Настя или Настя?
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.next();
        String name2 = scanner.next();
        int a, b;
        a = name1.length();
        b = name2.length();
        if (name1.equals(name2)) {
            System.out.println("Имена идентичны");
        } else if (a == b) {
            System.out.println("Длины имен равны");
        }
    }
}
