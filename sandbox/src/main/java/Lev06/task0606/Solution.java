package Lev06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numIn = Integer.parseInt(reader.readLine());
        String numText = String.valueOf(numIn);
        char[] numChar = numText.toCharArray();
        for (int i = 0; i < numText.length(); i++) {
            if (numChar[i] % 2 == 0) {
                even++;
            } else
                odd++;
        }
        System.out.println("Even: " + even + " " + "Odd: " + odd);
    }
}

