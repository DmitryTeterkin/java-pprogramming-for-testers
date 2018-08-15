package Lev07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        // заполняем список
        for (int i = 0; i < 10; i++) {
            list.add(i,reader.readLine());
        }
        // цикл проверки упорядоченности списка
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i+1).length() < list.get(i).length()){ // условие проверки длины двух соседних элементов
                System.out.println(i+1); break; // выводим элемент, и заканчиваем цикл
            }
        }
    }
}

