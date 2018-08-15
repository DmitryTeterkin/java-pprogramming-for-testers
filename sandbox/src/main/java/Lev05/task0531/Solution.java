package Lev05.task0531;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Совершенствуем функциональность
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int r = Integer.parseInt(reader.readLine());

        int minimum = min(a, b, c, d, r);


        System.out.println("Minimum = " + minimum);
    }


    public static int min(int a, int b, int c, int d, int r) {
        int minim;
        if (a <= b) {minim = a;} else minim = b;
        if (minim >= c){minim = c;}
        if (minim >= d){minim = d;}
        if (minim >= r){minim = r;}
        return minim;
    }
}
