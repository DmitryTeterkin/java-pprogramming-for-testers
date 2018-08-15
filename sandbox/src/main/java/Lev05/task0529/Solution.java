package Lev05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int b;
        double result, sum = 0.0;
        while (true) {
            String s = br.readLine();
           // b = Integer.parseInt(s);
            //sum = sum + b;
            if (s.equals("сумма"))
                break;
            b = Integer.parseInt(s);
            sum = sum + b;

        }

        System.out.println(sum);   //напишите тут ваш код
    }
}
