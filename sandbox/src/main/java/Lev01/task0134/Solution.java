package Lev01.task0134;

/* 
Набираем воду в бассейн
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getVolume(25, 5, 2));
    }

    public static long getVolume(int a, int b, int c) {
       long result = a * b * c * 1000;
       return result;//напишите тут ваш код
    }
}