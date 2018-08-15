package Lev07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] mas = new int[20];
        int maximum;
        int minimum;
        // наполняем массив
        for (int i = 0; i < 20; i++) {
            String s = reader.readLine();
            mas[i] = Integer.parseInt(s);
        }
        // ищем максимум и минимум
        maximum = mas[0]; minimum = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] > maximum){
                maximum = mas[i];
            }
            if (mas[i] < minimum){
                minimum = mas[i];
            }
        }
        // выводим результат поиска
        System.out.print(maximum + " " + minimum);
    }
}
