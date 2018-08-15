package Lev05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
Написать программу, которая:
1. считывает с консоли число N, которое должно быть больше 0
2. потом считывает N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.


Требования:
1. Программа должна считывать числа с клавиатуры.
2. В классе должен быть метод public static void main.
3. Нельзя добавлять новые методы в класс Solution.
4. Программа должна выводить на экран максимальное из введенных N чисел.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int quantity = Integer.parseInt((reader.readLine()));

        if (quantity > 0) {
            int[] a = new int[quantity];
            int maximum = Integer.MIN_VALUE;
            for (int i = 0; i < quantity; i++) {
                a[i] = Integer.parseInt((reader.readLine()));
               if (maximum < a[i]){maximum = a[i];}
            }
            System.out.println(maximum);
        }
    }
}
