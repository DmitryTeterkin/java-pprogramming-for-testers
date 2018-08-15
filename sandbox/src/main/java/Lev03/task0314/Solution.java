package Lev03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        int i;
        for (i = 1; i <= 10; i++){
            umn(i);
            System.out.println();
        }
    }

    public static void umn(int i) {
        int j;
        for (j = 1; j <= 10; j++){
            System.out.print(i * j + " ");
        }
    }
}
