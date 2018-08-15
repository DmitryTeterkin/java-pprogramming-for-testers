package Lev07.task0704;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] numbers = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //создаем массив
        for (int i = 0; i< numbers.length; i++){
            String s = reader.readLine();
            numbers[i] = Integer.parseInt(s);
        }
        //переворачиваем массив
        for (int i = numbers.length; i > 0; i--){
            System.out.println(numbers[i-1]);
        }
    }
}

