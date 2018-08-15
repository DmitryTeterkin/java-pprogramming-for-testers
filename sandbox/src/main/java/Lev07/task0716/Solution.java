package Lev07.task0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лоза"); //1
        list.add("лира"); //2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        ArrayList<String> mas = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.contains("р")) {
                if ((s.contains("р") && s.contains("л"))) {
                } else {
                    list.remove(i);
                    i--;
                }
            } else {
                if (s.contains("л")) {
                    mas.add(s);
                }
            }
        }
        for (int i= 0; i < mas.size(); i++){
            list.add(mas.get(i));
        }
        return list;
    }

}