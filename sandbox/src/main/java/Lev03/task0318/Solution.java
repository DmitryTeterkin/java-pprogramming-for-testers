package Lev03.task0318;

/* 
План по захвату мира
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sAge = reader.readLine();
        String name = reader.readLine();
        int nAge = Integer.parseInt(sAge);   //напишите тут ваш код
        System.out.println(name + " захватит мир через " + nAge + " лет. Му-ха-ха!");
    }
}
