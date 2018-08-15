package Lev01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
       int a, b, c, sum;
       a = number / 100;
       b = number % 100;
       c = b % 10;
       b = b / 10;
       sum = a + b + c;
        return sum; //напишите тут ваш код
    }
}