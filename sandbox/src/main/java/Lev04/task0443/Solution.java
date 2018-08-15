package Lev04.task0443;


/* 
Как назвали, так назвали
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String y = scanner.next();
        String m = scanner.next();
        String d = scanner.next();
        int a = Integer.parseInt(y);
        int b = Integer.parseInt(m);
        int c = Integer.parseInt(d);
        System.out.println("Меня зовут "+ name +".");
        System.out.println("Я родился "+ c +"." + b + "." + a);
    }
}
