package Lev03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertEurToUsd(100,1.312));
        System.out.println(convertEurToUsd(500,1.342));
    }

    public static double convertEurToUsd(int eur, double course) {
        double usd = eur*course;
        return usd;//напишите тут ваш код
    }
}
