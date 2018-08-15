package Lev07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // инициализируем списки
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list4 = new ArrayList<Integer>();
        // наполняем первый список данными
        for (int i = 0; i < 20; i++) {
            String s = reader.readLine();
            list1.add(i,Integer.parseInt(s));
        }
        // распихиваем цифры по спискам

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) % 3 == 0){
                list2.add(list1.get(i));
            }
            if (list1.get(i) % 2 == 0){
                list3.add(list1.get(i));
            }
            if (list1.get(i) % 3 != 0 && list1.get(i) % 2 != 0){
                list4.add(list1.get(i));
            }
        }
        printList(list1);
        printList(list2);
        printList(list3);
        printList(list4);
    }

    public static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
