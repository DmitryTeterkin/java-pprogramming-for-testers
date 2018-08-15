package Lev04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0, b = 0;
        while (true) {
            String s = br.readLine();
            b = Integer.parseInt(s);
            sum = sum + b;
            if (b == -1)
            break;
        }
        System.out.println(sum);
    }
}

