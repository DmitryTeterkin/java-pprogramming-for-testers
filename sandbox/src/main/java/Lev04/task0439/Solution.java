package Lev04.task0439;

/* 
Письмо счастья
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.next();
        for (int i = 0; i < 10; i++){
            System.out.println(name1 + " любит меня.");
        }
    }
}
