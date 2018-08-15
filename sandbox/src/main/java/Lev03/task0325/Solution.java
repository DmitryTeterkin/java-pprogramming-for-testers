package Lev03.task0325;

import java.io.*;

/* 
Финансовые ожидания
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sSum = reader.readLine();
        int nSum = Integer.parseInt(sSum);
        System.out.println("Я буду зарабатывать $"+nSum+" в час");
    }
}
