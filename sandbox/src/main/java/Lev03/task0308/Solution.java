package Lev03.task0308;

/* 
Произведение 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        int i, result;
        result = 1;
        for (i = 1; i<11; i++) {
         result = result * i;
        }
      System.out.println(result);
    }
}
