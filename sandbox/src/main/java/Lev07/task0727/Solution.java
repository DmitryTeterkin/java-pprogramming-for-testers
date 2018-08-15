package Lev07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.equals("")) {
                break;
            } else{
                list.add(s);

            }
        }

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.length() % 2 == 0){

                list.set(i, (s + " " + s));
            } else{

                list.set(i, (s + " " + s + " " + s));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
/*
    ArrayList<String> listUpperCase = new ArrayList<String>();
    for (int i = 0; i < list.size(); i++) {
      String s = list.get(i);
      listUpperCase.add(s.toUpperCase());
    }

    for (int i = 0; i < listUpperCase.size(); i++) {
      System.out.println(listUpperCase.get(i));
    }

*/

    }
}
