package Lev04.task0414;

/* 
Количество дней в году
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();  //напишите тут ваш код
       if(year%4==0 && year%100 !=0 || year%400==0){
        System.out.println("количество дней в году: 366");
    } else
        System.out.println("количество дней в году: 365");
    }
}