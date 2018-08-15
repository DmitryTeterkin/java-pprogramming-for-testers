package Lev07.task0715;

import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {

        public static void main(String[] args) {
            ArrayList<String> List = new ArrayList<String>();
            List.add(0,"мама");
            List.add(1,"мыла");
            List.add(2,"раму");
            for (int i = 0; i < List.size(); i++) {
                if (List.get(i) != "именно"){
                    List.add(i+1, "именно");}
            }
            for (int i =0; i< List.size(); i++){
                System.out.println(List.get(i));
            }
        }
    }

