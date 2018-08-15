package Lev03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String sSumm = reader.readLine();
        int nSumm = Integer.parseInt(sSumm);
        String sAge = reader.readLine();
        int nAge = Integer.parseInt(sAge);
        System.out.println(name + " получает " + nSumm + " через " + nAge + " лет.");
    }
}
