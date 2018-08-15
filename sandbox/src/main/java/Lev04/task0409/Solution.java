package Lev04.task0409;

/* 
Ближайшее к 10
*/

public class Solution {
    public static void main(String[] args) {
        closeToTen(9, 11);
        closeToTen(14, 9);
    }

    public static void closeToTen(int a, int b) {
     int first, second;
       first = abs((10-a)); second = abs(10 - b);
        if ( first < second) {
            System.out.println(a);
        } else {
            if (first == second){
                System.out.println(a);
            } else System.out.println(b);
        }
     }   //напишите тут ваш код



    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }
}